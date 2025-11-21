package exercicios;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class Exercicio2Test {

    @ParameterizedTest
    @DisplayName("Teste romano")
    @CsvSource({
            "I,1",
            "II,2",
            "III,3",
            "IV,4",
            "V,5",
            "VI,6",
            "VII,7",
            "VIII,8",
            "IX,9",
            "X,10",
            "XI,11",
            "XII,12",
            "XIII,13",
            "XIV,14",
            "XV,15",
            "XVI,16",
            "XVII,17",
            "XVIII,18",
            "XIX,19",
            "XX,20",
            "XXV,25",
            "XXX,30",
            "XXXV,35",
            "XL,40",
            "XLV,45",
            "L,50",
            "LX,60",
            "LXX,70",
            "LXXX,80",
            "XC,90",
            "C,100",
            "CX,110",
            "CXX,120",
            "CXXX,130",
            "CXL,140",
            "CL,150",
            "CLX,160",
            "CLXX,170",
            "CLXXX,180",
            "CXC,190",
            "CC,200",
            "CCL,250",
            "CCC,300",
            "CCCX,310",
            "CCCXX,320",
            "CCCXXX,330",
            "CCCXL,340",
            "CCCL,350",
            "CCCXC,390",
            "MMMCMXCIX,3999"
    })
    public void trsnformacao_DeveEstarCoesoComResultadoRomano (String numeroRomano, int numero) {
        var exercicio2 = new Exercicio2();
        assertEquals(numeroRomano, exercicio2.trsnformacao(numero));
    }

    @Test
    @DisplayName("Teste Throws com numero 4000")
    public void trsnformacao_testeErroValor4000 () {
        var exercicio2 = new Exercicio2();
        assertThrows(IllegalArgumentException.class, () -> exercicio2.trsnformacao(4000));
    }

    @Test
    @DisplayName("Teste Throws com 0")
    public void trsnformacao_testeErroValor0 () {
        var exercicio2 = new Exercicio2();
        assertThrows(IllegalArgumentException.class, () -> exercicio2.trsnformacao(0));
    }

    @Test
    @DisplayName("Teste Throws com -1")
    public void trsnformacao_testeErroValorUmNegativo () {
        var exercicio2 = new Exercicio2();
        assertThrows(IllegalArgumentException.class, () -> exercicio2.trsnformacao(-1));
    }
}