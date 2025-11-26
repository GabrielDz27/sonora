package exercicios;

public class Exercicio1 {
    public int[] ordenacao (int[] numero) {

        if (numero.length > 5) {
            throw new IllegalArgumentException("Ja acabou o seu limite");
        }

        boolean validado = false;

        while (!validado) {

            validado = true;

            for (int i = 0; i < (numero.length-1); i++) {
                if (numero[i] > numero[i+1]) {
                    int temp = numero[i];
                    numero[i] = numero[i+1];
                    numero[i+1] = temp;
                    validado = false;
                }
            }
        }

        return numero;
    }
}
