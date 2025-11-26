package exercicio2.test;

import exercicio2.exception.GerenteException;
import exercicio2.main.funcionarios.Gerente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class GerenteTest {

    @ParameterizedTest
    @DisplayName("Teste de valores para bonificação para Gerente, deve estar retornando 10% do salario")
    @CsvSource({
        //  Nome            Cpf                 Salario     10%
            "Ana Silva,     123.456.789-00,     3500.0,    350.00",
            "Bruno Souza,   987.654.321-11,     4200.0,    420.00",
            "Carla Pereira, 456.789.123-22,     5000.0,    500.00",
            "Diego Santos,  321.654.987-33,     2800.0,    280.00",
            "Fernanda Lima, 654.321.987-44,     6000.0,    600.00"
    })
    public void getBonificacao_DeveEstarCoeso(String nome, String cpf, BigDecimal salario, BigDecimal valor) {
        var gerente = new Gerente(nome, cpf, salario, "1Ab5@G2",4);
        /*
          @Explicacao:
             Todo é um funcionario, mas nem todo funcionario é um gerente;
              O metodo tem que ter a bonificação de 10% do salario
         */
        assertEquals(valor, gerente.getBonificacao());
    }

    @Test
    @DisplayName("Teste para senhas geral")
    public void validaSenha_geral() {
        assertThrows(
                GerenteException.class,
                ()-> new Gerente("nome", "123.456.789-00", new BigDecimal("3500.0"), "abro",1)
        );
    }
    @Test
    @DisplayName("Teste para senhas numero")
    public void validaSenha_numero() {
        assertThrows(
                GerenteException.class,
                ()-> new Gerente("nome", "123.456.789-00", new BigDecimal("3500.0"), "123",1)
        );
    }

    @Test
    @DisplayName("Teste validação de contagem de gerenciadores exception")
    public void validaContagemDegerenciadores_Deve() {
        assertThrows(
                GerenteException.class,
                () -> new Gerente("nome", "123.456.789-00", new BigDecimal("3500.0"), "1Ab5@G2",0)
        );
    }
}