package exercicio1.test;

import exercicio1.exception.AutomovelException;
import exercicio1.main.Carro;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CarroTest {

    @Test
    @DisplayName("Testando exception da validade do tempo de uso do carro")
    public void validaAnoFabricacao_DeveAbrirUmaExceptionAutomovel() {
        assertThrows(AutomovelException.class,
                () -> new Carro(
                        "Fiat",
                        "Uno Mille 1.0",
                        "Vermelho",
                        2005,
                        new BigDecimal(7500)
                )
        );
    }

    @Test
    @DisplayName("Testando exception da validade do ano do carro, não pode ser maior que atual ano")
    public void validaAnoFabricacao_DeveAbrirUmaExceptionAutomovelAnoMaiorQueAtual() {
        assertThrows(AutomovelException.class,
                () -> new Carro(
                        "Fiat",
                        "Uno Mille 1.0",
                        "Vermelho",
                        2026,
                        new BigDecimal(7500)
                )
        );
    }

    @Test
    @DisplayName("Testando a exception do valor da compra do carro")
    public void validaPrecoCompra_DeveAbrirUmaExceptionPrecoCompra() {
        assertThrows(AutomovelException.class,
                () -> new Carro(
                        "Fiat",
                        "Uno Mille 1.0",
                        "Vermelho",
                        2025,
                        new BigDecimal(-7500)
                )
        );
    }

    @Test
    @DisplayName("Testando exception da validade do IPVA: ")
    public void calcularIpva_DeveAbrirUmaExceptionAutomovel() {
        var carro = new Carro(
                "Fiat",
                "Uno Mille 1.0",
                "Vermelho",
                2007,
                new BigDecimal(7500));

        assertThrows(AutomovelException.class, () -> carro.calcularIpva());
    }

    @ParameterizedTest
    @DisplayName("Testando valores IPVA: ")
    @CsvSource({
        //  Ano        Valor da IPVA
            "2024,     285.0000",
            "2023,     270.7500",
            "2022,     257.2125",
            "2021,     244.3519",
            "2020,     232.1343",
            "2019,     220.5276",
            "2018,     209.5012",
            "2017,     199.0261",
            "2016,     189.0748",
    })
    public void calcularIpva_DeveEstarCoesoComValores(int ano, BigDecimal valorIPVA) {
        var carro = new Carro(
                "Fiat",
                "Uno Mille 1.0",
                "Vermelho",
                ano,
                new BigDecimal(7500)
        );

        assertEquals(valorIPVA, carro.calcularIpva());
    }


    @ParameterizedTest
    @DisplayName("Testando o calculo de revenda")
    @CsvSource({
        //  Ano        Valor da Revenda
            "2024,     7125.0000",
            "2023,     6768.7500",
            "2022,     6430.3125",
            "2021,     6108.7969",
            "2020,     5803.3570",
            "2019,     5513.1892",
            "2018,     5237.5297",
            "2017,     4975.6532",
            "2016,     4726.8706",
            "2015,     4490.5270",
    })
    public void calcularValorRevenda(int ano, BigDecimal valorRevenda) {
        var carro = new Carro(
                "Fiat",
                "Uno Mille 1.0",
                "Vermelho",
                ano,
                new BigDecimal(7500)
        );

        assertEquals(
                valorRevenda,
                carro.calcularValorRevenda()
        );
    }


    @Test
    @DisplayName("Tempo de uso")
    public void calcularTempoDeUsoEmAnos() {
        var carro = new Carro("Fiat",
                "Uno Mille 1.0",
                "Vermelho",
                2007,
                new BigDecimal(7500)
        );

        assertEquals(
                18,
                carro.calcularTempoDeUsoEmAnos()
        );
    }

    @Test
    @DisplayName("Testando o toString IPVA maior do que 10 anos")
    public void toString_validandoIpvaMaiorDoQue10Anos() {
        var carro = new Carro(
                "Fiat",
                "Uno Mille 1.0",
                "Vermelho",
                2007,
                new BigDecimal(7500)
        );

        assertTrue(carro.toString().startsWith("Carro"));
    }

    @Test
    @DisplayName("Testando o toString  IPVA menor do que 10 anos")
    public void toString_validandoIpvaMenorDoQue10Anos() {
        var carro = new Carro(
                "Fiat",
                "Uno Mille 1.0",
                "Vermelho",
                2017,
                new BigDecimal(7500)
        );

        assertTrue(carro.toString().startsWith("Carro"));
    }
}