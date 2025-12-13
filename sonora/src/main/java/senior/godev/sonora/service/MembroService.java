package senior.godev.sonora.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senior.godev.sonora.models.membro.Membro;
import senior.godev.sonora.models.membro.formatacao.DadosAtualizacaoMembro;
import senior.godev.sonora.models.membro.formatacao.DadosCadastroMembro;
import senior.godev.sonora.models.membro.formatacao.DadosDetalhamentoMembro;
import senior.godev.sonora.models.membro.formatacao.DadosListagemMembro;
import senior.godev.sonora.models.usuario.Usuario;
import senior.godev.sonora.repository.MembroRepository;
import senior.godev.sonora.repository.UsuarioRepository;

@Service
public class MembroService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MembroRepository membroRepository;

    public DadosDetalhamentoMembro cadastrar(@Valid DadosCadastroMembro dadosCadastroMembro) {
        Usuario usuario = usuarioRepository.findByLogin(dadosCadastroMembro.login())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Membro novoMembro = new Membro(
                dadosCadastroMembro,
                usuario.getId(),
                usuario.getEmail()
        );

        return montarDtoDetalhamento(membroRepository.save(novoMembro));
    }

    @Transactional
    public DadosDetalhamentoMembro atualizarMembro(@Valid DadosAtualizacaoMembro dadosAtualizacaoMembro) {
        var membro = membroRepository.getReferenceById(dadosAtualizacaoMembro.id());

        membro.atualizarInformacoes(dadosAtualizacaoMembro);

        Usuario usuario = usuarioRepository.findByLogin(dadosAtualizacaoMembro.login())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        usuario.atualizarEmail(dadosAtualizacaoMembro.email());

        return montarDtoDetalhamento(membro);
    }

    @Transactional(readOnly = true)
    public DadosDetalhamentoMembro detalharMembro(Long id) {
        return montarDtoDetalhamento(membroRepository.findAllById(id));
    }

    private DadosDetalhamentoMembro montarDtoDetalhamento(Membro membro) {

        Usuario usuario = usuarioRepository.findById(membro.getUsuario_id())
                .orElseThrow(() -> new RuntimeException("Usuário relacionado não encontrado."));

        return new DadosDetalhamentoMembro(
                membro,
                usuario.getLogin()
        );
    }

    public Page<DadosListagemMembro> listagemMembro(Pageable paginacao) {
        return membroRepository.findAllDetalhamentoListagem(paginacao);
    }
}