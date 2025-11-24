package metodos.gabriel.main;

import metodos.gabriel.exception.FibonacciException;

import java.math.BigInteger;
import java.util.TreeMap;

public class Fibonacci {

    private TreeMap<Integer, BigInteger> fibonacciCache = new TreeMap <> ();

    public BigInteger fibonacci (int numero) {
        if (numero < 0) throw new FibonacciException("Valor negativo");

        try {

            if (numero == 1 || numero == 0) return BigInteger.valueOf(numero);

            if (fibonacciCache.get(numero) != null) return fibonacciCache.get(numero);

            BigInteger resultado = fibonacci(numero - 1).add(fibonacci(numero - 2));
            fibonacciCache.put(numero,resultado);

            return resultado;
        }  catch (FibonacciException f) {
            throw new FibonacciException("Erro no Metodo");
        }
    }
}
