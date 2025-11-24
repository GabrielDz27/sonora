package metodos.gabriel.test;

import metodos.gabriel.exception.FibonacciException;
import metodos.gabriel.main.Fibonacci;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {

    static Stream<Arguments> dadosFibonacci() {
        return Stream.of(
                Arguments.of(0, BigInteger.ZERO),
                Arguments.of(10, new BigInteger("55"))
        );
    }
    @ParameterizedTest
    @MethodSource("dadosFibonacci")
    @DisplayName("Teste do metodo fibonacci")
    public void fibonacci_DeveEstarCoesoComOResultado(int numero, BigInteger resultado) {
        var recursividade = new Fibonacci();
        assertEquals(resultado, recursividade.fibonacci(numero));
    }

    // se fosse long teria ido ate 93 ou 92
    @Test
    @DisplayName("Teste com um numero longo")
    public void fibonacci_DeveEstarCoesoComOResultadoLongo() {
        var recursividade = new Fibonacci();
        assertEquals(new BigInteger("19740274219868223167"),recursividade.fibonacci(94));
    }

    @Test
    @DisplayName("Teste com um numero negativo")
    public void fibo_DeveAtivarUmaException() {
        var recursividade = new Fibonacci();
        assertThrows(FibonacciException.class, () -> recursividade.fibonacci(-1));
    }
}