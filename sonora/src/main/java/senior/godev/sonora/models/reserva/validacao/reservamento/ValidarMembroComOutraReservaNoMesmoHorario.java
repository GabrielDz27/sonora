package senior.godev.sonora.models.reserva.validacao.reservamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.reserva.dto.DadosCadastroReserva;
import senior.godev.sonora.repository.ReservaRepository;

@Component
public class ValidarMembroComOutraReservaNoMesmoHorario implements ValidadorReservamento {
    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public void validar(DadosCadastroReserva dadosCadastroReserva) {
        if (
                Boolean.TRUE.equals(reservaRepository.
                        existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNullAndIdMembroAndIdSala(
                                dadosCadastroReserva.dataHoraInicio(),
                                dadosCadastroReserva.dataHoraFim(),
                                dadosCadastroReserva.idMembro(),
                                dadosCadastroReserva.idSala()
                        ))
        ) {
            throw new ValidacaoException("""
                    Já existe uma reserva do membro no mesmo horario,
                     só pode se realizar reservas de salas diferentes com horarios diferentes
                    """);

        }
    }
}
