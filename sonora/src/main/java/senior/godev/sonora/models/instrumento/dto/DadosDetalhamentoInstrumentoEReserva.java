package senior.godev.sonora.models.instrumento.dto;

import senior.godev.sonora.models.reserva.TipoUso;
import senior.godev.sonora.repository.projections.InstrumentoReservaProjection;

public record DadosDetalhamentoInstrumentoEReserva(
        Long idInstrumento,
        String nome,
        String modelo,
        Long idSala,
        Boolean emUso,
        TipoUso tipoUso
) {
    public DadosDetalhamentoInstrumentoEReserva(InstrumentoReservaProjection instrumentoReservaProjection) {
        this(
                instrumentoReservaProjection.getIdInstrumento(),
                instrumentoReservaProjection.getNome(),
                instrumentoReservaProjection.getModelo(),
                instrumentoReservaProjection.getIdSala(),
                instrumentoReservaProjection.getEmUso(),
                instrumentoReservaProjection.getTipoUso()
        );
    }
}
