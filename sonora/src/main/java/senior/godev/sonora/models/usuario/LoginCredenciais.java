package senior.godev.sonora.models.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Validando os valores para o login endpoint /auth/login
 */
public record LoginCredenciais(
        @NotBlank
        @Size(max = 60)
        String login,
        @NotBlank
        String senha
) {
}