import metodos.gabriel.main.Fibonacci;

public class Main {

    public static void main(String[] args) {
        var fibonacci = new Fibonacci();

        System.out.println("+----------------------------------------------+");
        System.out.println("|                  Fibonacci                   |");
        System.out.println("+----------------------------------------------+");
        for (int i = 0; i <= 95; i++) {
            if (i % 5 == 0) System.out.println("");
            System.out.print(fibonacci.fibonacci(i) + " ");
        }

        System.out.println();
        System.out.println("+--------------------------------------------+");


    }
}