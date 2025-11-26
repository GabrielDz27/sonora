package exercicio2.test;

import exercicio1.exception.PessoaException;
import exercicio1.main.Pessoa;
import exercicio2.exception.FuncionarioException;
import exercicio2.main.funcionarios.Funcionario;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.lang.annotation.Documented;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {

    @ParameterizedTest
    @DisplayName("Teste de valores para bonificação para funcionarios, deve estar retornando 5% do salario")
    @CsvSource({
        //  Nome            Cpf                 Salario     5%
            "Ana Silva,     123.456.789-00,     3500.00,    175.00",
            "Bruno Souza,   987.654.321-11,     4200.00,    210.00",
            "Carla Pereira, 456.789.123-22,     5000.00,    250.00",
            "Diego Santos,  321.654.987-33,     2800.00,    140.00",
            "Fernanda Lima, 654.321.987-44,     6000.00,    300.00"
    })
    public void getBonificacao_DeveEstarCoeso(String nome, String cpf, BigDecimal salario, BigDecimal valor) {
        var funcionario = new Funcionario(nome, cpf, salario);
        /*
          @Explicacao:
             Todo funcionario tem que ter a bonificação de 5% do salario
         */
        assertEquals(valor, funcionario.getBonificacao());
    }

    @Test
    @DisplayName("Testando exception para o salario ser positivo")
    public void validaSalario_DeveEstarCoeso() {
        assertThrows(FuncionarioException.class, () -> new Funcionario("Gabriel", "09090909222", new BigDecimal("-444")));
    }

    @ParameterizedTest
    @DisplayName("Testando valores nulos no nome")
    @NullAndEmptySource
    void validaNome(String nome) {
        assertThrows(FuncionarioException.class, () -> new Funcionario(nome,"09090909221", new BigDecimal("2500.0")).validaNome());
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
    void validaCpf(String cpf) {
        assertThrows(FuncionarioException.class, () -> new Funcionario("Gabriel",cpf, new BigDecimal("2500.0")).validaCpf());
    }

}