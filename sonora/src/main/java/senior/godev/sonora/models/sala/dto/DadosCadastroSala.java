package senior.godev.sonora.models.sala.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroSala(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 1, max = 100)
        @Valid
        String nome,

        int capacidade,

        @NotNull(message = "É obrigatório informar se tem abafadores na sala ou não tem abafadores")
        Boolean temAbafadores

) {
}
