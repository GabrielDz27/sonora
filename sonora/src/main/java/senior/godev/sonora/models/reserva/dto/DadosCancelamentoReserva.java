package senior.godev.sonora.models.reserva.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import senior.godev.sonora.models.reserva.MotivoCancelamento;

public record DadosCancelamentoReserva(
        @NotNull(message = "Deve conter o id da reserva")
        Long idReserva,

        @NotNull
        @Enumerated(EnumType.STRING)
        MotivoCancelamento motivo
) {
}
