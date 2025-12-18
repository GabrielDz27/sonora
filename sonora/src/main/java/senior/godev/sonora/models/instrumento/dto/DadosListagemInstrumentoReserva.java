package senior.godev.sonora.models.instrumento.dto;

import java.time.LocalDateTime;

public record DadosListagemInstrumentoReserva(
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFinal
) {
}
