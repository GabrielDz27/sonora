package exercicio3.main;

import exercicio3.exception.ItemPedidoException;

import java.math.BigDecimal;

public class ItemPedido {
    protected int qtde;
    private BigDecimal valorPedido = BigDecimal.ZERO;

    public ItemPedido(Produto produto, int qtde) {
        this.qtde = qtde;
        this.valorPedido = produto.valor;
        validaQtd();
    }

    private void validaQtd() {
        if (qtde <= 0) {
            throw new ItemPedidoException("Quantidade deve ser maior do que zero");
        }
    }

    public BigDecimal obterValorItemPedido() {
        return valorPedido;
    }
}
