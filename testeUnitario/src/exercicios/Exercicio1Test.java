package exercicios;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Exercicio1Test {

    static Stream<Arguments> dadosOrdenacao() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 3, 5, 2, 4}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{2, 5, 1, 4, 3}),

                Arguments.of(new int[]{1,2,3,4,5},new int[]{3,1,4,5,2}),
                Arguments.of(new int[]{1,2,3,4,5},new int[]{5,2,4,1,3}),
                Arguments.of(new int[]{1,2,3,4,5},new int[]{4,1,3,5,2}),
                Arguments.of(new int[]{1,2,3,4,5},new int[]{2,4,1,5,3}),
                Arguments.of(new int[]{1,2,3,4,5},new int[]{3,5,2,1,4}),
                Arguments.of(new int[]{1,2,3,4,5},new int[]{5,3,1,4,2}),
                Arguments.of(new int[]{1,2,3,4,5},new int[]{4,2,5,3,1}),
                Arguments.of(new int[]{1,2,3,4,5},new int[]{1,5,3,2,4})
        );
    }

    @ParameterizedTest
    @DisplayName("Teste de ordenacao")
    @MethodSource("dadosOrdenacao")
    public void testeOrdenacao(int[] resultado, int[] dados) {
        var exercicio1 = new Exercicio1();
        assertArrayEquals(resultado,exercicio1.ordenacao(dados));
    }

    @Test
    @DisplayName("Teste Throws")
    public void testeExecption() {
        var exercicio1 = new Exercicio1();
        assertThrows(IllegalArgumentException.class, () -> exercicio1.ordenacao(new int[]{1, 2, 3, 4, 6,7}));
    }
}