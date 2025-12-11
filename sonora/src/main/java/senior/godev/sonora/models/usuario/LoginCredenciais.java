package senior.godev.sonora.models.usuario;

import jakarta.validation.constraints.NotBlank;

/**
 * Validando os valores para o login endpoint /auth/login
 */
public record LoginCredenciais(
        @NotBlank
        String login,
        @NotBlank
        String senha
) {
}