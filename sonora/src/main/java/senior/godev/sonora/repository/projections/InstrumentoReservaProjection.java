package senior.godev.sonora.repository.projections;

import senior.godev.sonora.models.reserva.TipoUso;

public interface InstrumentoReservaProjection {

    Long getIdInstrumento();

    String getNome();

    String getModelo();

    Long getIdSala();

    Boolean getEmUso();

    TipoUso getTipoUso();
}
