package metodos.gabriel.test;

import metodos.gabriel.main.SomaPares;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SomaParesTest {

    @ParameterizedTest
    @DisplayName("Teste do metodo da Soma de Pares")
    @CsvSource({
            "2  ,   2   ",
            "3  ,   2   ",
            "4  ,   6   ",
            "5  ,   6   ",
            "6  ,   12  ",
            "7  ,   12  ",
            "8  ,   20  ",
            "10 ,   30  ",
    })
    public void somaPares_DeveEstarCoesoComOResultado(int numero, int resultado) {
        var recursividade = new SomaPares();
        assertEquals(resultado, recursividade.somaPares(numero));
    }

}