package senior.godev.sonora.models.sala.formatacao;

import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.models.sala.dto.SalaDetalhamentoCompleto;

public record DadosDetalhamentoCompletoSala(Sala sala, long qtdInstrumento, String nomes_instrumentos) {
    public DadosDetalhamentoCompletoSala(SalaDetalhamentoCompleto salaDetalhamento) {
        this(
                salaDetalhamento.getSala(), salaDetalhamento.getCount(), salaDetalhamento.getNomes_instrumentos()
        );
    }
}
