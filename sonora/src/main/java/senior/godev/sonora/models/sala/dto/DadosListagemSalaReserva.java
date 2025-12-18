package senior.godev.sonora.models.sala.dto;

import java.time.LocalDateTime;

public record DadosListagemSalaReserva(

        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFinal
) {
}
