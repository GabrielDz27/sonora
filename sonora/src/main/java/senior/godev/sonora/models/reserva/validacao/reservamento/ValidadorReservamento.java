package senior.godev.sonora.models.reserva.validacao.reservamento;

import senior.godev.sonora.models.reserva.formatacao.DadosCadastroReserva;

public interface ValidadorReservamento {
    void validar(DadosCadastroReserva dadosCadastroReserva);
}
