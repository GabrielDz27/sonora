package senior.godev.sonora.models.sala.formatacao;

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

        int capacidade,

        @NotNull
        Boolean temAbafadores
) {
}
