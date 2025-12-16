package senior.godev.sonora.models.reserva.formatacao;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import senior.godev.sonora.models.reserva.TipoUso;

import java.time.LocalDateTime;

public record DadosCadastroReserva(
        Long idMembro,

        Long idInstrumento,

        @NotNull(message = "A sala deve ser informada")
        Long idSala,

        @NotNull(message = "A data e a hora deve ser informada")
        @Future(message = "A data deve ser futuro")
        LocalDateTime dataHoraInicio,

        @NotNull(message = "A data e a hora deve ser informada")
        @Future(message = "A data deve ser futuro")
        LocalDateTime dataHoraFim,

        @NotNull(message = "O tipo de uso deve ser informado")
        @Enumerated(EnumType.STRING)
        TipoUso tipoUso,

        String observacoes
) {
}
