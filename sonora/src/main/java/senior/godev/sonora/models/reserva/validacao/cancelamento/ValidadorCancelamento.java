package senior.godev.sonora.models.reserva.validacao.cancelamento;

import senior.godev.sonora.models.reserva.formatacao.DadosCancelamentoReserva;

public interface ValidadorCancelamento {
    void validar(DadosCancelamentoReserva dados);
}
