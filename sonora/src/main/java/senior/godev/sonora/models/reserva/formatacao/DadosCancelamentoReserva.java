package senior.godev.sonora.models.reserva.formatacao;

import jakarta.validation.constraints.NotNull;
import senior.godev.sonora.models.reserva.MotivoCancelamento;

public record DadosCancelamentoReserva(
        @NotNull
        Long idReserva,

        @NotNull
        MotivoCancelamento motivo
) {
}
