package senior.godev.sonora.models.sala.formatacao;

import senior.godev.sonora.models.sala.Sala;

public record DadosDetalhamentoSala(Long idSala, String nome, int getCapacidade, Boolean temAbafadores) {
    public DadosDetalhamentoSala(Sala sala) {
        this(
                sala.getId(), sala.getNome(), sala.getCapacidade(), sala.getTemAbafadores()
        );
    }
}
