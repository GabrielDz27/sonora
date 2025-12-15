package senior.godev.sonora.repository.projections;

import senior.godev.sonora.models.reserva.TipoUso;

public interface SalaReservaProjection {
    Long getId();

    String getNome();

    int getCapacidade();

    Boolean getTemAbafadores();

    Boolean getEmUso();

    TipoUso getTipoUso();
}
