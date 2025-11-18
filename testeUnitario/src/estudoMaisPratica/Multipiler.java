package estudoMaisPratica;

public class Multipiler {
    public int multiplica(int a, int b) {
        if (a < 0 && b < 0) {
            throw new ArithmeticException();
        }

        return a * b;
    }
}
