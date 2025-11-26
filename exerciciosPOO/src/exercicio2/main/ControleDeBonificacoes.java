package exercicio2.main;

import exercicio2.main.funcionarios.Funcionario;

import java.math.BigDecimal;

public class ControleDeBonificacoes {
    private BigDecimal totalBonificacao = BigDecimal.ZERO;

    public void registra(Funcionario funcionario){
        totalBonificacao = totalBonificacao.add(funcionario.getBonificacao());
    }

    public BigDecimal getTotalBonificacao() {
        return totalBonificacao;
    }
}
