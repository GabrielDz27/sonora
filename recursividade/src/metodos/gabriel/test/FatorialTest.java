package metodos.gabriel.test;

import metodos.gabriel.exception.FatorialException;
import metodos.gabriel.main.Fatorial;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class FatorialTest {

    @ParameterizedTest
    @DisplayName("Teste do metodo fatorial")
    @CsvSource({
            "1  ,   1       ",
            "2  ,   2       ",
            "3  ,   6       ",
            "4  ,   24      ",
            "5  ,   120     ",
            "6  ,   720     ",
            "7  ,   5040    ",
            "8  ,   40320   "
    })
    public void fatorial_DeveEstarCoesoComOResultado(int numero, BigInteger resultado) {
        var recursividade = new Fatorial();
        assertEquals(resultado, recursividade.fatorial(numero));
    }

    @Test
    @DisplayName("Teste com numero 0 para aparecer 1")
    public void fatorial_DeveEstarCoesoComOResultadoUm() {
        var recursividade = new Fatorial();
        assertEquals(BigInteger.ONE, recursividade.fatorial(0));
    }

    @Test
    @DisplayName("Teste com numero graende no fatorial")
    public void fatorial_DeveEstarCoesoComOResultadoGrande() {
        var recursividade = new Fatorial();
        assertEquals(new BigInteger("2432902008176640000"), recursividade.fatorial(20));
    }

    @Test
    @DisplayName("Teste de Throw fatorial")
    public void fatorial_DeveAtivarUmaException() {
        var recursividade = new Fatorial();
        assertThrows(FatorialException.class, () -> recursividade.fatorial(-1));
    }
}