package senior.godev.sonora.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.membro.Membro;
import senior.godev.sonora.models.membro.dto.DadosAtualizacaoMembro;
import senior.godev.sonora.models.membro.dto.DadosCadastroMembro;
import senior.godev.sonora.models.membro.dto.DadosDetalhamentoMembro;
import senior.godev.sonora.models.membro.dto.DadosListagemMembro;
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

    var membroExistente = membroRepository.findByCpf(dadosCadastroMembro.cpf());

    if (membroExistente.isPresent()) {
      Membro membro = membroExistente.get();

      if (membro.getAtivo()) {
        throw new ValidacaoException("Este CPF já possui um cadastro ativo.");
      }

      membro.reativar(dadosCadastroMembro, usuario);
      return montarDtoDetalhamento(membro);
    }

    Membro novoMembro = new Membro(
      dadosCadastroMembro,
      usuario,
      usuario.getEmail()
    );

    usuario.atualizarRole(dadosCadastroMembro.role());

    return montarDtoDetalhamento(membroRepository.save(novoMembro));
  }

  @Transactional
  public DadosDetalhamentoMembro atualizarMembro(@Valid DadosAtualizacaoMembro dadosAtualizacaoMembro) {
    if (!membroRepository.existsById(dadosAtualizacaoMembro.id())) {
      throw new ValidacaoException("O id do membro não existe");
    }

    var membro = membroRepository.getReferenceById(dadosAtualizacaoMembro.id());

    membro.atualizarInformacoes(dadosAtualizacaoMembro);

    Usuario usuario = usuarioRepository.findByLogin(dadosAtualizacaoMembro.login())
      .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

    usuario.atualizarEmail(dadosAtualizacaoMembro.email());

    usuario.atualizarRole(dadosAtualizacaoMembro.role());

    return montarDtoDetalhamento(membro);
  }

  @Transactional(readOnly = true)
  public DadosDetalhamentoMembro detalharMembro(Long id) {
    if (!membroRepository.existsById(id)) {
      throw new ValidacaoException("O id do membro não existe");
    }
    return montarDtoDetalhamento(membroRepository.findAllById(id));
  }

  private DadosDetalhamentoMembro montarDtoDetalhamento(Membro membro) {

    Usuario usuario = usuarioRepository.findById(membro.getUsuario().getId())
      .orElseThrow(() -> new RuntimeException("Usuário relacionado não encontrado."));

    return new DadosDetalhamentoMembro(
      membro,
      usuario.getLogin(),
      usuario.getRole()
    );
  }

  public Page<DadosListagemMembro> listagemMembro(Pageable paginacao) {
    return membroRepository.findAllDetalhamentoListagem(paginacao);
  }

  @Transactional
  public void excluirMembro(Long id) {
    if (!membroRepository.existsById(id)) {
      throw new ValidacaoException("Não foi encontrado o membro pra excluir.");
    }

    var membro = membroRepository.getReferenceById(id);
    var usuario = usuarioRepository.findByLogin(membro.getUsuario().getLogin())
      .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

    usuario.removeMembro(membro);
    membro.excluir();
  }

  public DadosDetalhamentoMembro detalharMembroPorLogin(String login) {
    var membro = membroRepository.findBylogin(login);

    if (membro == null) {
      throw new EntityNotFoundException("Membro não encontrado para o login: " + login);
    }

    return montarDtoDetalhamento(membro);
  }
}
