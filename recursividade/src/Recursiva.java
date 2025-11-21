public class Recursiva {

    public int fatorial (int numero) {
        if (numero == 0) return 1;

        return numero * fatorial(numero - 1);
    }

    public int somaPares (int numero) {
        if (numero == 0) return 0;

        return numero % 2 == 0 ? numero + somaPares (numero -1) : somaPares (numero -1);
    }

    public int fibonacci (int numero) {
        if (numero == 0) return 0;
        if (numero == 1) return 1;

        return fibonacci(numero - 1) + fibonacci(numero - 2);
    }
}
