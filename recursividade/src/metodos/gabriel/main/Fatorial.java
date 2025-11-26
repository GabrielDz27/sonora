package metodos.gabriel.main;

import metodos.gabriel.exception.FatorialException;

import java.math.BigInteger;

public class Fatorial {

    public BigInteger fatorial (int numero) {
        if (numero < 0) throw new FatorialException("Numero negativo");

        if (numero == 0) return BigInteger.ONE;

        try {
            return fatorial(numero-1).multiply(BigInteger.valueOf(numero));
        } catch (FatorialException f) {
            throw new FatorialException("Erro no Metodo");
        }
    }
}
