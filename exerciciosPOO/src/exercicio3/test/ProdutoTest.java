package exercicio3.test;

import exercicio3.exception.ProdutoException;
import exercicio3.main.Produto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @ParameterizedTest
    @DisplayName("Testando exceptions com null")
    @NullSource
    public void validaValor_testandoExceptionsComNull(BigDecimal valor) {
        assertThrows(
                ProdutoException.class,
                () -> new Produto(123,valor,"impr")
        );
    }

    @Test
    @DisplayName("Testando exceptions com numero negativo")
    public void validaValor_testandoExceptionsComNumeroNegativo() {
        assertThrows(
                ProdutoException.class,
                () -> new Produto(123,new BigDecimal("-1"),"xbox")
        );
    }

    @ParameterizedTest
    @DisplayName("Testando a descricao vazio ou null")
    @NullAndEmptySource
    public void validaDescicao_testandoOsValoresVazioOuNull(String descricao) {
        assertThrows(
                ProdutoException.class,
                () -> new Produto(123,new BigDecimal("1"),descricao)
        );
    }

}