package senior.godev.sonora.models.sala.formatacao;

import senior.godev.sonora.models.reserva.TipoUso;
import senior.godev.sonora.repository.projections.SalaReservaProjection;

public record DadosDetalhamentoSalaEReserva(
        Long idSala, String nome, int getCapacidade, Boolean temAbafadores, Boolean emUso, TipoUso tipoUso
) {
    public DadosDetalhamentoSalaEReserva(SalaReservaProjection sala) {
        this(
                sala.getId(),
                sala.getNome(),
                sala.getCapacidade(),
                sala.getTemAbafadores(),
                sala.getEmUso(),
                sala.getTipoUso()
        );
    }
}
