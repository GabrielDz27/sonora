package estudoMaisPratica;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MultipilerTest {

    //Teste comum
    @Test
    public void multiplicaDeveDar10() {
        var multipiler = new Multipiler();
        assertEquals(10, multipiler.multiplica(2, 5));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,2",
            "0,2,0",
            "1,7,7",
            "9,23,207",
            "10,3,30",
            "-1,2,-2"
    })
    public void deveMultiplicarCorretamente(int a, int b,  int eseperado) {
        var resultado = new Multipiler().multiplica(a, b);
        assertEquals(resultado, eseperado);
    }

    @Test //dar erro
    public void deveErroNaMultiplica() {
        assertThrows(ArithmeticException.class, () -> new Multipiler().multiplica(-1, -5));
    }


}