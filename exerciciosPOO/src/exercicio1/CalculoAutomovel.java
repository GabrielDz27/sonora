package exercicio1;

import exercicio1.main.Carro;
import exercicio1.main.Pessoa;

import java.math.BigDecimal;

public class CalculoAutomovel {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        var carro = new Carro(
                "Fiat",
                "Uno Mille 1.0",
                "Vermelho",
                2007,
                new BigDecimal(7500));

        System.out.println(".... "+carro);
    }
}
