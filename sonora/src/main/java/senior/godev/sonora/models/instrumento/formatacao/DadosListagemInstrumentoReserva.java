package senior.godev.sonora.models.instrumento.formatacao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.time.LocalDateTime;

public record DadosListagemInstrumentoReserva(
        @PageableDefault(size = 20, sort = {"id"}) Pageable paginacao,
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFinal
) {
}
