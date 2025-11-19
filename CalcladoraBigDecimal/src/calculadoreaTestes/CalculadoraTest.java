package calculadoreaTestes;

import calculadora.Calculadora;
import org.junit.Test;
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
    @MethodSource("dadosBigDecimalAdd")
    void addSimples(BigDecimal numero1, BigDecimal numero2, BigDecimal resultado) {
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
    @MethodSource("dadosBigDecimalSub")
    void subSimples(BigDecimal numero1, BigDecimal numero2, BigDecimal resultado) {
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
    @MethodSource("dadosBigDecimalMul")
    void mulSimples(BigDecimal numero1, BigDecimal numero2, BigDecimal resultado) {
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
    @MethodSource("dadosBigDecimalDiv")
    void divSimples(BigDecimal numero1, BigDecimal numero2, BigDecimal resultado) {
        Calculadora calculadora = new Calculadora(numero1, numero2);
        assertEquals(resultado, calculadora.divisao());
    }

    @Test
    public void divErroDivisao() {
        Calculadora calculadora = new Calculadora(new BigDecimal("2"), BigDecimal.ZERO);
        assertThrows(ArithmeticException.class, calculadora::divisao);
    }

}