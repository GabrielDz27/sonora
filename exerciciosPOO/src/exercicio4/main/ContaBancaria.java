package exercicio4.main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class ContaBancaria {
    private BigInteger numero = BigInteger.ZERO;
    private BigInteger agencia = BigInteger.ZERO;
    private BigDecimal saldo = BigDecimal.ZERO;
    TipoConta tipoConta;

    public ContaBancaria(BigInteger numero, BigInteger agencia, BigDecimal saldo, TipoConta tipoConta) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    public boolean sacar(BigDecimal valor){
        if (saldo.compareTo(BigDecimal.ZERO) <= 0) return false;

        if (saldo.compareTo(valor) <= 0) return false;

        if (tipoConta == TipoConta.CONTA_CORRENTE) {
            saldo = saldo.subtract(new BigDecimal("0.5"));
        }

        saldo = saldo.subtract(valor);

        saldo = saldo.setScale(4, RoundingMode.HALF_EVEN);

        return true;
    }

    public boolean depositar(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) <= 0) return false;

        saldo = saldo.add(valor);

        saldo = saldo.setScale(4, RoundingMode.HALF_EVEN);

        return true;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
