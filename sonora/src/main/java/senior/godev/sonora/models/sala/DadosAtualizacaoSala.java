package senior.godev.sonora.models.sala;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoSala(
        @NotNull
        Long id,
        
        @NotBlank
        @Size(min = 1, max = 100)
        @Valid
        String nome,

        @NotBlank
        int capacidade,

        @NotNull
        Boolean tem_abafadores
) {
}
