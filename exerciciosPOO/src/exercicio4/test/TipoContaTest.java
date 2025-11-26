package exercicio4.test;

import exercicio4.main.ContaBancaria;
import exercicio4.main.TipoConta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class TipoContaTest {

    @Test
    @DisplayName("Testando conta poupanca com valores simples")
    public void testarTipoConta_Poupanca() {
        var contaBancaria = new ContaBancaria(
                new BigInteger("1231231231"),
                new BigInteger("443"),
                new BigDecimal("100"),
                TipoConta.POUPANCA
        );

        /**
         * Conta poupanca não possui taxa qual quando o saque é realizado e cobrado na corrente
         */

        contaBancaria.sacar(BigDecimal.valueOf(50));
        assertEquals(new BigDecimal("50.0000"), contaBancaria.getSaldo());
    }

    @Test
    @DisplayName("Testando conta corrente com valores simples")
    public void testarTipoConta_Corrente() {
        var contaBancaria = new ContaBancaria(
                new BigInteger("1231231231"),
                new BigInteger("443"),
                new BigDecimal("100"),
                TipoConta.CONTA_CORRENTE
        );

        /**
         * Conta corrente possui taxa qual quando o saque é realizado e cobrado 50 centavos
         */

        contaBancaria.sacar(BigDecimal.valueOf(50));
        assertEquals(new BigDecimal("49.5000"), contaBancaria.getSaldo());
    }
}