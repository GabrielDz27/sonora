package exercicio3.test;

import exercicio3.main.Pedido;
import exercicio3.main.Produto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    @DisplayName("Teste com parametrização de valores")
    public void obterValorPedido_DeveEstaComValorCoeso() {
        var pedido = new Pedido();
        pedido.adicionarItem(new Produto(12312, new BigDecimal("10.0"), "tapeteg"), 4);
        pedido.adicionarItem(new Produto(12312, new BigDecimal("10.0"), "tapetea"), 2);
        pedido.adicionarItem(new Produto(12312, new BigDecimal("10.0"), "tapetes"), 1);
        pedido.adicionarItem(new Produto(12312, new BigDecimal("10.0"), "tapetef"), 5);

        assertEquals(new BigDecimal("120.0"), pedido.obterValorPedido());
    }
}