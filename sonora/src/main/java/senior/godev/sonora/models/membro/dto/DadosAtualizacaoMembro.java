package senior.godev.sonora.models.membro.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import senior.godev.sonora.models.membro.endereco.DadosEndereco;
import senior.godev.sonora.models.usuario.IdentificacaoUsuario;

import java.time.LocalDate;

public record DadosAtualizacaoMembro(
        @NotNull
        Long id,

        @NotNull
        String login,

        @NotBlank(message = "Cpf é obrigatório")
        @Pattern(
                regexp = "^\\d{11}$",
                message = "CPF inválido"
        )
        String cpf,

        @NotNull(message = "A data de nascimento é obrigatório")
        @Past(message = "A data de nascimento tem que ser no passado")
        LocalDate dataNascimento,

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 1, max = 255)
        String nome,

        @NotBlank
        @Email
        @Size(min = 1, max = 250)
        String email,

        @Pattern(
                regexp = "^\\d{10,11}$",
                message = "Telefone inválido"
        )
        String telefone,

        @NotNull(message = "A classificação do usuário é obrigatório")
        IdentificacaoUsuario role,

        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
