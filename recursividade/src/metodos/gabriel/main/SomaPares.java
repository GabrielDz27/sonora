package metodos.gabriel.main;

public class SomaPares {
    public int somaPares (int numero) {
        if (numero == 0) return 0;

        return numero % 2 == 0 ? numero + somaPares (numero -1) : somaPares (numero -1);
    }
}
