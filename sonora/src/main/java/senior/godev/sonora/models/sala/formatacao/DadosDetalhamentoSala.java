package senior.godev.sonora.models.sala.formatacao;

import senior.godev.sonora.models.sala.Sala;

public record DadosDetalhamentoSala(Long id_sala, String nome, int getCapacidade, Boolean tipo_instrumento) {
    public DadosDetalhamentoSala(Sala sala) {
        this(
                sala.getId(), sala.getNome(), sala.getCapacidade(), sala.getTem_abafadores()
        );
    }
}
