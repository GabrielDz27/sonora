package exercicio2.main.funcionarios;

import exercicio2.exception.GerenteException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Gerente extends Funcionario {
    private String senha;
    private int qtdeGerenciados;

    public Gerente(String nome, String cpf, BigDecimal salario, String senha, int qtdeGerenciados) {
        super(nome, cpf, salario);

        validaSenha(senha);
        validaQtdeGerenciados(qtdeGerenciados);

        this.senha = senha;
        this.qtdeGerenciados = qtdeGerenciados;
    }

    private void validaSenha(String senha) {

        String mensagem = "";

        if (senha.length() < 6) {
            mensagem += "\n Pelo menos 6 caracteres na senha";
        }
        if (!senha.matches(".*[A-Z].*")) {
            mensagem += "\n Pelo menos uma Letra maiuscula na senha";
        }
        if (!senha.matches(".*[a-z].*")) {
            mensagem += "\n Pelo menos uma Letra minuscula na senha";
        }
        if (!senha.matches(".*[0-9].*")) {
            mensagem += "\n Pelo menos um numero na senha";
        }
        if (!senha.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            mensagem += "\n Pelo menos um caractere especial na senha";
        }

        if (!mensagem.isEmpty()) {
            throw new GerenteException(mensagem);
        }
    }

    public void validaQtdeGerenciados(int qtdeGerenciados) {
        if(qtdeGerenciados < 1){
            throw new GerenteException("Quantidade de gerenciados acima de 0");
        }
    }

    @Override
    public BigDecimal getBonificacao() {
        return super.salario.multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.HALF_EVEN);
    }
}
