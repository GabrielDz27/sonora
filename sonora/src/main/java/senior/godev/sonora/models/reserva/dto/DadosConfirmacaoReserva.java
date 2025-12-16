package senior.godev.sonora.models.reserva.dto;

import jakarta.validation.constraints.NotNull;

public record DadosConfirmacaoReserva(

        @NotNull(message = "O id da reserva é obrigatorio")
        Long id
) {
}
