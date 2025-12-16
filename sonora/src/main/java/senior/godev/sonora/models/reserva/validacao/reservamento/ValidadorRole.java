package senior.godev.sonora.models.reserva.validacao.reservamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.reserva.TipoUso;
import senior.godev.sonora.models.reserva.dto.DadosCadastroReserva;
import senior.godev.sonora.models.usuario.IdentificacaoUsuario;
import senior.godev.sonora.repository.MembroRepository;
import senior.godev.sonora.repository.UsuarioRepository;

@Component
public class ValidadorRole implements ValidadorReservamento {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private UsuarioRepository userRepository;

    public void validar(DadosCadastroReserva dadosCadastroReserva) {
        var usuarioO = userRepository
                .findByLogin(
                        membroRepository.findAllById(
                                dadosCadastroReserva.idMembro()
                        ).getUsuario().getLogin()
                );

        if (usuarioO.get().getRole().equals(IdentificacaoUsuario.ALUNO) && dadosCadastroReserva.tipoUso().equals(TipoUso.AULA)) {
            throw new ValidacaoException("Somente professores podem fazer reserva para o tipo de uso AULA");
        }
    }
}
