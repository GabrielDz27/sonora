package calculadoreaTestes;

import calculadora.Calculadora;
import org.junit.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    //Alguns testes

    //Add
    static Stream<Arguments> dadosBigDecimalAdd() {
        return Stream.of(
                Arguments.of(new BigDecimal("2"),new BigDecimal("2"),new BigDecimal("4")),
                Arguments.of(new BigDecimal("2"),new BigDecimal("-2"),new BigDecimal("0")),
                Arguments.of(new BigDecimal("20"),new BigDecimal("2"),new BigDecimal("22")),
                Arguments.of(new BigDecimal("1000000000.5"),new BigDecimal("2"),new BigDecimal("1000000002.5"))
        );
    }

    @ParameterizedTest
    @DisplayName("Adicao de quatro ocasioes")
    @MethodSource("dadosBigDecimalAdd")
    void adicao_addSimples(BigDecimal numero1, BigDecimal numero2, BigDecimal resultado) {
        Calculadora calculadora = new Calculadora(numero1, numero2);
        assertEquals(resultado, calculadora.adicao());
    }

    //Sub
    static Stream<Arguments> dadosBigDecimalSub() {
        return Stream.of(
                Arguments.of(new BigDecimal("2"),new BigDecimal("2"),new BigDecimal("0")),
                Arguments.of(new BigDecimal("2"),new BigDecimal("-2"),new BigDecimal("4")),
                Arguments.of(new BigDecimal("20"),new BigDecimal("2"),new BigDecimal("18")),
                Arguments.of(new BigDecimal("1000000000.5"),new BigDecimal("2"),new BigDecimal("999999998.5"))
        );
    }

    @ParameterizedTest
    @DisplayName("Subtracao de quatro ocasioes")
    @MethodSource("dadosBigDecimalSub")
    void subtracao_subSimples(BigDecimal numero1, BigDecimal numero2, BigDecimal resultado) {
        Calculadora calculadora = new Calculadora(numero1, numero2);
        assertEquals(resultado, calculadora.subtracao());
    }

    //Mul
    static Stream<Arguments> dadosBigDecimalMul() {
        return Stream.of(
                Arguments.of(new BigDecimal("2"),new BigDecimal("2"),new BigDecimal("4")),
                Arguments.of(new BigDecimal("2"),new BigDecimal("-2"),new BigDecimal("-4")),
                Arguments.of(new BigDecimal("20"),new BigDecimal("2"),new BigDecimal("40")),
                Arguments.of(new BigDecimal("1000000000.5"),new BigDecimal("2"),new BigDecimal("2000000001.0"))
        );
    }

    @ParameterizedTest
    @DisplayName("Multiplicação de quatro ocasioes")
    @MethodSource("dadosBigDecimalMul")
    void multiplicar_mulSimples(BigDecimal numero1, BigDecimal numero2, BigDecimal resultado) {
        Calculadora calculadora = new Calculadora(numero1, numero2);
        assertEquals(resultado, calculadora.multiplicar());
    }

    //Div
    static Stream<Arguments> dadosBigDecimalDiv() {
        return Stream.of(
                Arguments.of(new BigDecimal("2"),new BigDecimal("2"),new BigDecimal("1")),
                Arguments.of(new BigDecimal("2"),new BigDecimal("-2"),new BigDecimal("-1")),
                Arguments.of(new BigDecimal("20"),new BigDecimal("2"),new BigDecimal("10")),
                Arguments.of(new BigDecimal("1000000000.5"),new BigDecimal("2"),new BigDecimal("500000000.25"))
        );
    }

    @ParameterizedTest
    @DisplayName("Divisao de quatro ocasioes")
    @MethodSource("dadosBigDecimalDiv")
    void divisao_divSimples(BigDecimal numero1, BigDecimal numero2, BigDecimal resultado) {
        Calculadora calculadora = new Calculadora(numero1, numero2);
        assertEquals(resultado, calculadora.divisao());
    }

    @Test
    @DisplayName("Divisao testando com 0 para execao")
    public void divisao_divErroDivisao() {
        Calculadora calculadora = new Calculadora(new BigDecimal("2"), BigDecimal.ZERO);
        assertThrows(ArithmeticException.class, () -> calculadora.divisao());
    }

    @Test
    @DisplayName("Divisao testando com 0 para execao")
    public void divisao_divErroDivisaoPeriodica() {
        var calculadora = new Calculadora(new BigDecimal("1"), new BigDecimal("3"));
        assertThrows(ArithmeticException.class, () -> calculadora.divisao());
    }
}