package calculadora;

import java.math.BigDecimal;

public class Calculadora implements CalculadoraRegras {
    private final BigDecimal a;
    private final BigDecimal b;

    public Calculadora(BigDecimal a, BigDecimal b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public BigDecimal adicao() {
        return a.add(b);
    }

    @Override
    public BigDecimal subtracao() {
        return a.subtract(b);
    }

    @Override
    public BigDecimal multiplicar(){
        return a.multiply(b);
    }

    @Override
    public BigDecimal divisao(){

        try {
            return a.divide(b);
        } catch (ArithmeticException e){
            throw new ArithmeticException("Erro ao divisao");
        }
    }

}
