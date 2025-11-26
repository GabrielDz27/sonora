package exercicio1.test;

import exercicio1.exception.PessoaException;
import exercicio1.main.Pessoa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @ParameterizedTest
    @DisplayName("Testando valores nulos no nome")
    @NullAndEmptySource
    void setNome(String nome) {
        Pessoa p = new Pessoa();
        assertThrows(PessoaException.class, () -> p.setNome(nome));
    }

    @ParameterizedTest
    @DisplayName("Testando valores para cpf")
    @CsvSource({
            "11111111111",
            "22222222222",
            "33333333333",
            "333333333336",
            "44444444444",
            "55555555555",
            "66666666666",
            "77777777777",
            "88888888888",
            "99999999999",
            "dsf23f32f23"
    })
    void setCpf(String cpf) {
        Pessoa pessoa = new Pessoa();
        assertThrows(PessoaException.class, () -> pessoa.setCpf(cpf));
    }
}