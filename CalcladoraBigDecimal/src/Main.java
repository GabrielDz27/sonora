import calculadora.Calculadora;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var Calculadora = new Calculadora(new BigDecimal("2"),new BigDecimal("3"));

        System.out.println(Calculadora.adicao());
        System.out.println(Calculadora.subtracao());
        System.out.println(Calculadora.multiplicar());
        System.out.println(Calculadora.divisao());


    }
}