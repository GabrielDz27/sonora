package senior.godev.sonora.models.reserva.validacao.reservamento;

import senior.godev.sonora.models.reserva.dto.DadosCadastroReserva;

public interface ValidadorReservamento {
    void validar(DadosCadastroReserva dadosCadastroReserva);
}
