package exercicio2.main.funcionarios;

import exercicio2.exception.FuncionarioException;
import meth.ValidaCpf;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Funcionario {
    private String nome;
    private String cpf;
    protected BigDecimal salario = BigDecimal.ZERO;

    public Funcionario(String nome, String cpf, BigDecimal salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;

        validaSalario();
        validaNome();
        validaCpf();
    }

    public void validaSalario() {
        if (salario.compareTo(BigDecimal.ZERO) < 0) {
            throw new FuncionarioException("Salario negativo, deve ser positivo");
        }
    }

    public void validaNome() {
        if (nome == null || nome.isEmpty()) {
            throw new FuncionarioException("O nome do funcionario deve ser informado");
        }
    }

    public void validaCpf() {
        var validaCpf = new ValidaCpf();
        if (!validaCpf.isCpf(cpf)) {
            throw new FuncionarioException("Cpf invalido");
        }
    }

    public BigDecimal getBonificacao() {
        return salario.multiply(new BigDecimal("0.05")).setScale(2, RoundingMode.HALF_EVEN);
    }
}
