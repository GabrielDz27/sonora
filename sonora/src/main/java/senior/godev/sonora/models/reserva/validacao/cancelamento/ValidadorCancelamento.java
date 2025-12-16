package senior.godev.sonora.models.reserva.validacao.cancelamento;

import senior.godev.sonora.models.reserva.dto.DadosCancelamentoReserva;

public interface ValidadorCancelamento {
    void validar(DadosCancelamentoReserva reserva);
}
