package senior.godev.sonora.models.reserva.validacao.confirmacao;

import senior.godev.sonora.models.reserva.dto.DadosConfirmacaoReserva;

public interface ValidadorConfirmacao {
    void validar(DadosConfirmacaoReserva dadosConfirmacaoReserva);
}
