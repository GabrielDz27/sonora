package senior.godev.sonora.repository.projections;

public interface SalaProjection {
    Long getId();

    String getNome();

    int getCapacidade();

    Boolean getTem_Abafadores();

    Long getQuantidadeInstrumentos();

    String getNomesInstrumentos();
}
