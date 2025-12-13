package senior.godev.sonora.models.membro.formatacao;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import senior.godev.sonora.models.membro.endereco.DadosEndereco;

import java.time.LocalDate;

public record DadosCadastroMembro(
        @NotBlank(message = "O usuário é obrigatorio")
        String login,

        @NotBlank(message = "Cpf é obrigatório")
        @Pattern(
                regexp = "(\\d)\\1{10}",
                message = "CPF inválido"
        )
        String cpf,

        @NotBlank(message = "A data de nascimento é obrigatório")
        @Past
        LocalDate data_nascimento,

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 1, max = 255)
        String nome,

        @NotNull
        @Valid
        DadosEndereco endereco

) {
}
