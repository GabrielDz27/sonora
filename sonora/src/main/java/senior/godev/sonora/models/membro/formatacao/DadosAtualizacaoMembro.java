package senior.godev.sonora.models.membro.formatacao;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import senior.godev.sonora.models.membro.endereco.DadosEndereco;

import java.time.LocalDate;

public record DadosAtualizacaoMembro(
        @NotNull
        Long id,

        @NotNull
        String login,

        @NotBlank(message = "Cpf é obrigatório")
        @Pattern(
                regexp = "(\\d)\\1{10}",
                message = "CPF inválido"
        )
        String cpf,

        @NotBlank(message = "A data de nascimento é obrigatório")
        @Past(message = "A data de nascimento tem que ser no passado")
        LocalDate dataNascimento,

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 1, max = 255)
        String nome,

        @NotBlank
        @Email
        String email,

        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
