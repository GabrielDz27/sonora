package senior.godev.sonora.service;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import senior.godev.sonora.models.usuario.DadosAtualizacaoSenhaUsuario;

import static org.junit.jupiter.api.Assertions.assertFalse;

class UsuarioServiceTest {

    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @ParameterizedTest
    @DisplayName("Deve invalidar senhas que não seguem o padrão de segurança")
    @CsvSource({
            "12345, A senha deve conter pelo menos uma letra",
            "Senha123, A senha deve conter pelo menos um caractere especial",
            "senha@123, A senha deve conter pelo menos uma letra maiúscula",
            "SENHA@123, A senha deve conter pelo menos uma letra minúscula",
            "S@12, A senha contém caracteres não permitidos"
    })
    void validarSenha_CenariosInvalidos(String senhaInvalida) {
        var dto = new DadosAtualizacaoSenhaUsuario("usuario", senhaInvalida, "email@valido.com");

        var violacoes = validator.validate(dto);

        assertFalse(violacoes.isEmpty());
    }
}