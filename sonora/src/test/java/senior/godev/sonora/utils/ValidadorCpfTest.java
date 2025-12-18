package senior.godev.sonora.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorCpfTest {

    @Test
    void validarCpf_ComValorCpfValido() {
        var validadorCpf = new ValidadorCpf();
        assertTrue(validadorCpf.validarCpf("12345678909"));
    }

    @ParameterizedTest
    @DisplayName("Validar o cpf com todos os tipos de de valores, de negativos, repetidos pra retornar um exception e false")
    @CsvSource({
            "11111111111",
            "123",
            "123456789012",
            "abc12345678",
            "00000000000",
            "-123.456.789-00",
            "123.456.789-0-1",
            "-1"
    })
    void validarCpf_ComValoresDistintosParaSairFalse(String cpf) {
        var validadorCpf = new ValidadorCpf();
        assertFalse(validadorCpf.validarCpf(cpf));

    }

    @ParameterizedTest
    @DisplayName("Validar com valores nulos")
    @NullAndEmptySource
    void validarCpf_ComValoresNulos(String cpf) {
        var validadorCpf = new ValidadorCpf();
        assertFalse(validadorCpf.validarCpf(cpf));
    }
}