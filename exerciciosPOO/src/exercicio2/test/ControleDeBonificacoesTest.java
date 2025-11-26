package exercicio2.test;

import exercicio2.main.ControleDeBonificacoes;
import exercicio2.main.funcionarios.Funcionario;
import exercicio2.main.funcionarios.Gerente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ControleDeBonificacoesTest {

    @Test
    @DisplayName("Testando o metodo registrar com gerente e funcionario")
    void registra_DeveEstarRegistrando() {

        var controleDeBonificacoes = new ControleDeBonificacoes();
        controleDeBonificacoes
            .registra(
                new Gerente(
                        "Orcelino",
                        "09090909222",
                        new BigDecimal("5000.0"),
                        "1Ab5@G2",
                        6
                )
            );

        controleDeBonificacoes
            .registra(
                new Funcionario(
                        "Jose",
                        "85885432123",
                        new BigDecimal("2400.0")
                )
            );
    }

    @Test
    @DisplayName("Testando o metodo getTotalBonificacao, Com gerete e funcionario para sair um total coesente")
    void getTotalBonificacao_DeveEstarComTotalCoesente() {

        var controleDeBonificacoes = new ControleDeBonificacoes();

        controleDeBonificacoes
            .registra(
                new Gerente(
                        "Orcelino",
                        "09090909222",
                        new BigDecimal("5000.0"),
                        "1Ab5@G2",
                        6
                )
            );

        controleDeBonificacoes
            .registra(
                new Funcionario(
                        "Jose",
                        "85885432123",
                        new BigDecimal("2400.0")
                )
            );

        assertEquals(
                new BigDecimal("620.00"),
                controleDeBonificacoes.getTotalBonificacao()
        );
    }
}