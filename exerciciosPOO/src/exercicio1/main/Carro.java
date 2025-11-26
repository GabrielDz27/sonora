package exercicio1.main;

import exercicio1.exception.AutomovelException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Carro implements Automovel{
    private String fabricante;
    private String modelo;
    private String cor;
    private int anoFabricacao;
    private BigDecimal precoCompra;

    public Carro(String fabricante, String modelo, String cor, int anoFabricacao, BigDecimal precoCompra) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.precoCompra = precoCompra;

        validaAnoFabricacao();
        validaPrecoCompra();
    }

    public void validaAnoFabricacao() {
        if (calcularTempoDeUsoEmAnos() >= 20) {
            throw new AutomovelException("A Vida útil do carro passo");
        }

        if (anoFabricacao > LocalDate.now().getYear()) {
            throw new AutomovelException("Ano de fabricação invalida, deve ser igual ou menor do ano atual");
        }
    }

    public void validaPrecoCompra() {
        if (precoCompra.compareTo(BigDecimal.ZERO) <= 0) {
            throw new AutomovelException("Tem que ser um valor acima de 0 da compra");
        }
    }

    @Override
    public BigDecimal calcularIpva() {

        int idadeCarro = calcularTempoDeUsoEmAnos();

        if (idadeCarro > 10) {
            throw new AutomovelException("Carros com mais de 10 anos de uso não pagam IPVA");
        }

        try {
            BigDecimal revenda = calcularValorRevenda();
            /**
                 @Explicacao:
                 IPVA é 4% do valor, mas se estiver com mais de 10 de uso não paga mais ipva
             */
            return revenda.multiply(new BigDecimal("0.04")).setScale(4, RoundingMode.HALF_EVEN);
        } catch (AutomovelException e) {
            throw new AutomovelException(e.getMessage());
        }
    }

    @Override
    public BigDecimal calcularValorRevenda() {

        int idadeCarro = calcularTempoDeUsoEmAnos();

        try {
            /**
                @Explicacao:
                    Juros compostos vai somar o juros mais o valor do montante,
                    juros de 5% , então o valor vai para 105%;
                    Neste caso de depreciação, tem que ser 95% do valor do carro
                    pois cada ano vai ser menos 5% do valor da compra

                Montante = Capital * (1 - taxaJuros) ^ tempo
             */

             BigDecimal revenda = precoCompra
                .multiply((
                    BigDecimal.ONE
                        .subtract(
                            new BigDecimal("0.05")
                        )
                ).pow(idadeCarro));

             return revenda.setScale(4, RoundingMode.HALF_EVEN);
        } catch (AutomovelException e) {
            throw new AutomovelException(e.getMessage());
        }
    }

    @Override
    public int calcularTempoDeUsoEmAnos() {
        int anoAtual = LocalDate.now().getYear();

        return anoAtual - anoFabricacao;
    }

    @Override
    public String toString() {
        return "Carro: \n Fabricante: " + fabricante
                + ", Modelo: " + modelo
                + ", Cor: " + cor
                + ", Ano fabrição: " + anoFabricacao
                + ", Preço de compra: " + precoCompra.setScale(4, RoundingMode.HALF_EVEN)
                + ", Preço de revenda: " +  calcularValorRevenda()
                + ", IPVA: " + (calcularTempoDeUsoEmAnos()<10? calcularIpva() : 0.0);
    }
}
