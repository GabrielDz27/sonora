package senior.godev.sonora.models.reserva.validacao.confirmacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.reserva.MotivoCancelamento;
import senior.godev.sonora.models.reserva.dto.DadosConfirmacaoReserva;
import senior.godev.sonora.repository.ReservaRepository;

import java.time.LocalDateTime;

@Component
public class ValidadorDataHoraConfirmacao implements ValidadorConfirmacao {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public void validar(DadosConfirmacaoReserva dadosConfirmacaoReserva) {
        var dataHoraReserva = reservaRepository
                .findAllById(dadosConfirmacaoReserva.id())
                .getDataHoraInicio();

        int dataReserva = dataHoraReserva.getDayOfYear();

        int agora = LocalDateTime.now().getDayOfYear();

        if (dataReserva > agora) {
            throw new ValidacaoException("So pode confirmar no dia que foi agendado a reserva");
        }

        var reserva = reservaRepository.findAllById(dadosConfirmacaoReserva.id());
        if (dataHoraReserva.getMonthValue() < 10 && !reserva.getEmEspera() && reserva.getMotivoCancelamento().equals(MotivoCancelamento.PENDENTE_CONFIRMACAO)) {
            throw new ValidacaoException("A sua reserva foi cancelada");
        }
    }
}
