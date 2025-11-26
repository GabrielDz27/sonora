package exercicio3.main;

import java.math.BigDecimal;

public class Pedido {
    private BigDecimal valorTotal = BigDecimal.ZERO;

    public void adicionarItem(Produto produto, int qtde) {
        var item = new ItemPedido(produto, qtde);
        valorTotal = valorTotal
                .add(
                    item.obterValorItemPedido()
                    .multiply(
                            BigDecimal.valueOf(item.qtde)
                    )
        );
    }

    public BigDecimal obterValorPedido() {
        return valorTotal;
    }
}
