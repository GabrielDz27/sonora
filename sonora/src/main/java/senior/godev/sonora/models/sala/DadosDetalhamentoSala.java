package senior.godev.sonora.models.sala;

public record DadosDetalhamentoSala(Long id, String nome, int capacidade, Boolean tem_abafadores) {
    public DadosDetalhamentoSala(Sala sala) {
        this(
                sala.getId(), sala.getNome(), sala.getCapacidade(), sala.getTem_abafadores()
        );
    }
}
