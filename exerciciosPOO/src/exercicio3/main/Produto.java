package exercicio3.main;

import exercicio3.exception.ProdutoException;

import java.math.BigDecimal;

public class Produto {
    protected int codigo;
    protected BigDecimal valor;
    protected String descricao;

    public Produto(int codigo, BigDecimal valor, String descricao) {
        this.codigo = codigo;
        this.valor = valor;
        this.descricao = descricao;

        validaValor();
        validaDescricao();
    }

    private void validaValor() {
        if (valor == null) {
            throw new ProdutoException("Deve ter um valor no produto");
        }
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new ProdutoException("Deve ser valor maior que zero");
        }
    }

    private void validaDescricao() {
        if (descricao == null || descricao.isEmpty()) {
            throw new ProdutoException("Descrição deve ser informado");
        }
    }
}
