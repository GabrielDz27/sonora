package senior.godev.sonora.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import senior.godev.sonora.models.sala.dto.DadosCadastroSala;
import senior.godev.sonora.models.sala.dto.DadosDetalhamentoSala;
import senior.godev.sonora.repository.SalaRepository;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class SalaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroSala> dadosCadastroSalaJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoSala> dadosDetalhamentoSalaJson;

    @Autowired
    private SalaRepository salaRepository;


    @Test
    void cadastrar() {

    }

    @Test
    void atualizar() {
    }

    @Test
    void excluir() {
    }

    @Test
    void detalhar() {
    }

    @Test
    void listar() {
    }

    @Test
    void listarSalasEReservas() {
    }
}