package senior.godev.sonora.models.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Validando utilizando o @Valid
 * Validando todos os registros para cadastrar no endpoint /auth/register
 */
public record DadosCadastroUsuario(
        @NotBlank(message = "O username é obrigatório")
        @Size(max = 60)
        String login,
        @NotBlank(message = "A senha é obrigatória")
        @Pattern.List({
                @Pattern(regexp = ".*\\d.*", message = "A senha deve conter pelo menos um dígito (0-9)."),
                @Pattern(regexp = ".*[a-z].*", message = "A senha deve conter pelo menos uma letra minúscula (a-z)."),
                @Pattern(regexp = ".*[A-Z].*", message = "A senha deve conter pelo menos uma letra maiúscula (A-Z)."),
                @Pattern(regexp = ".*[\\$*&@#].*", message = "A senha deve conter pelo menos um caractere especial: $, *, &, @ ou #."),
                @Pattern(regexp = "^[0-9a-zA-Z\\$*&@#]+$", message = "A senha contém caracteres não permitidos. Use apenas letras, números e $, *, &, @ ou #.")
        })
        String senha,
        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        @Size(max = 250)
        String email
) {
}
