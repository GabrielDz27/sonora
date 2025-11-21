import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class RecursivaTest {

    //Fatorial
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
    public void fatorial_DeveEstarCoesoComOResultado(int numero, int resultado) {
        var recursividade = new Recursiva();
        assertEquals(resultado, recursividade.fatorial(numero));
    }

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
         var recursividade = new Recursiva();
         assertEquals(resultado, recursividade.somaPares(numero));
    }

    @ParameterizedTest
    @DisplayName("Teste do metodo fibonacci")
    @CsvSource({
        "0  ,   0   ",
        "1  ,   1   ",
        "2  ,   1   ",
        "3  ,   2   ",
        "4  ,   3   ",
        "5  ,   5   ",
        "6  ,   8   ",
    })
    public void fibonacci_DeveEstarCoesoComOResultado(int numero, int resultado) {
        var recursividade = new Recursiva();
        assertEquals(0, recursividade.fibonacci(0));
    }
}