package senior.godev.sonora.models.reserva.validacao.cancelamento;

import org.springframework.stereotype.Component;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.reserva.MotivoCancelamento;
import senior.godev.sonora.models.reserva.dto.DadosCancelamentoReserva;

@Component
public class ValidadorMotivoCancelamento implements ValidadorCancelamento {
    public void validar(DadosCancelamentoReserva reserva) {
        if (reserva.motivo().equals(MotivoCancelamento.NAO_CONFIRMACAO_TEMPO)) {
            throw new ValidacaoException("Não pode selecionar esse motivo de cancelamento, procure outro");
        }
        if (reserva.motivo().equals(MotivoCancelamento.PENDENTE_CONFIRMACAO)) {
            throw new ValidacaoException("Não pode selecionar esse motivo de cancelamento, procure outro");
        }
    }
}
