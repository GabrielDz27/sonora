package exercicio4.test;

import exercicio4.main.ContaBancaria;
import exercicio4.main.TipoConta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ContaBancariaTest {

    @Test
    @DisplayName("saldo vazio")
    public void sacar_SaldoVazio() {
        var contaBancaria = new ContaBancaria(
                new BigInteger("1231231231"),
                new BigInteger("443"),
                BigDecimal.ZERO,
                TipoConta.CONTA_CORRENTE
        );

        assertFalse(contaBancaria.sacar(BigDecimal.valueOf(500)));
    }

    @Test
    @DisplayName("saldo vazio")
    public void sacar_SaldoMenorSaque() {
        var contaBancaria = new ContaBancaria(
                new BigInteger("1231231231"),
                new BigInteger("443"),
                new BigDecimal("100"),
                TipoConta.CONTA_CORRENTE
        );

        assertFalse(contaBancaria.sacar(BigDecimal.valueOf(500)));
    }

    @Test
    @DisplayName("Testar o saque na conta corrente")
    public void saque_ContaCorrente() {
        var contaBancaria = new ContaBancaria(
                new BigInteger("1231231231"),
                new BigInteger("443"),
                new BigDecimal("100"),
                TipoConta.CONTA_CORRENTE
        );

        assertTrue(contaBancaria.sacar(BigDecimal.valueOf(50)));
    }


    @Test
    @DisplayName("Testar o saque na conta corrente")
    public void getSaldo_ContaCorrente() {
        var contaBancaria = new ContaBancaria(
                new BigInteger("1231231231"),
                new BigInteger("443"),
                new BigDecimal("100"),
                TipoConta.CONTA_CORRENTE
        );

        contaBancaria.sacar(BigDecimal.valueOf(50));
        assertEquals(new BigDecimal("49.5000"), contaBancaria.getSaldo());
    }

    @Test
    @DisplayName("Testar o deposito com valor 0")
    public void depositar() {
        var contaBancaria = new ContaBancaria(
                new BigInteger("1231231231"),
                new BigInteger("443"),
                new BigDecimal("100"),
                TipoConta.POUPANCA
        );

        assertFalse(contaBancaria.depositar(BigDecimal.ZERO));
    }

    @Test
    @DisplayName("Testar valor normal para depositar")
    public void depositar_valorNormalParaDepositar() {
        var contaBancaria = new ContaBancaria(
                new BigInteger("1231231231"),
                new BigInteger("443"),
                new BigDecimal("100"),
                TipoConta.POUPANCA
        );

        assertTrue(contaBancaria.depositar(BigDecimal.ONE));
    }
}