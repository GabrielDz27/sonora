package estudoMaisPratica;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {

    /*
    * Code Coverage
    *
    * Atingir todas as branches condicionais (if / else)
    * Incluir o caso de exceção (ramo negativo)
    * Cobrir casos exatos de fronteira (ex: 60, 70, 80, 90)
    *
    * Boas praticas :
    * Usar nomes descritivos
    * Preparar -> Executar -> Verificar (arrange/act/Assert)
    *
    */

    //    assertEquals(expected, actual) — verifica que os dois valores são iguais
    //    assertNotEquals(u, v) — verifica que não são iguais
    //    assertTrue(condiçãoBooleana) — exige que a condição seja verdadeira
    //    assertFalse(condiçãoBooleana) — exige que a condição seja falsa
    //    assertNull(obj) — exige que o objeto seja null
    //    assertNotNull(obj) — exige que o objeto não seja null

    @Test
    public void twoAddTwoshouldFour() {
        var simpleCalculator = new SimpleCalculator();
        assertEquals(4, simpleCalculator.add(2, 2));
        // usar bastante o assert[assertTrue(a == a); assertNotNull(); ]
        assertThrows(ArithmeticException.class, () -> simpleCalculator.add(2, 2));
    }
      //--------------------//
     //teste parametrizados//
    //--------------------//
   //utilizando ValueSource
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    public void deveSerNumeroPar(int valor) {
        assertTrue(valor % 2 == 0);
    }

    //CsvSource formata para csv para testar
    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "10,5,15",
            "7,8,15"
    })
    public void deveSomarCorretamente(int a , int b, int eseperado) {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(eseperado,calculator.add(a,b));
    }

    //MethodSource
    static Stream<Arguments> dadosSubtracao() {
        return Stream.of(
                Arguments.of(10, 5, 5),
                Arguments.of(20, 7, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("dadosSubtracao")
    public void deveSubtracao(int a, int b, int eseperado) {
        var resultado = new SimpleCalculator().sub(a,b);
        assertEquals(eseperado,resultado);
    }

    static Stream<Arguments> dadosDivisao() {
        return Stream.of(
                Arguments.of(10,2,5),
                Arguments.of(24,2,12),
                Arguments.of(20,2,10),
                Arguments.of(10,2,5)
        );
    }

    @ParameterizedTest
    @MethodSource("dadosDivisao")
    public void deveDivisao(int a, int b, int eseperado) {
        var resultado = new SimpleCalculator().divide(a,b);
        assertTrue(eseperado == resultado);
    }

    @Test
    public void erroEsperadoDivisao() {
        var resultado = new SimpleCalculator();
        assertThrows(ArithmeticException.class, () -> resultado.divide(6,0));
    }
}