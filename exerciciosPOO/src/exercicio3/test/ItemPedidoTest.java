package exercicio3.test;

import exercicio3.exception.ItemPedidoException;
import exercicio3.main.ItemPedido;
import exercicio3.main.Produto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ItemPedidoTest {
    @Test
    @DisplayName("Deve abrir uma exception")
    public void validaQtd_Exception() {

        assertThrows(
                ItemPedidoException.class,
                () -> new ItemPedido(new Produto(123,new BigDecimal("1"),"tapete"), -1)
        );
    }
}