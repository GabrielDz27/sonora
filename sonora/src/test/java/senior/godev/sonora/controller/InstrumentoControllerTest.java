package senior.godev.sonora.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.instrumento.TipoInstrumento;
import senior.godev.sonora.models.instrumento.dto.DadosAtualizacaoInstrumento;
import senior.godev.sonora.models.instrumento.dto.DadosCadastroInstrumento;
import senior.godev.sonora.models.instrumento.dto.DadosDetalhamentoInstrumento;
import senior.godev.sonora.models.instrumento.dto.DadosListagemInstrumentoReserva;
import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.repository.InstrumentoRepository;
import senior.godev.sonora.repository.SalaRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class InstrumentoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroInstrumento> dadosCadastroInstrumentoJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoInstrumento> dadosDetalhamentoInstrumentoJson;

    @Autowired
    private JacksonTester<DadosAtualizacaoInstrumento> dadosAtualizacaoInstrumentoJson;

    @Autowired
    private JacksonTester<DadosListagemInstrumentoReserva> dadosListagemReservaJson;

    @MockitoBean
    private InstrumentoRepository instrumentoRepository;

    @MockitoBean
    private SalaRepository salaRepository;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void cadastrar_DeveRetornar400() throws Exception {
        var response = mvc
                .perform(post("/instrumentos"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void cadastrar_DeveRetornar200() throws Exception {
        var dadosCadastro = new DadosCadastroInstrumento(
                TipoInstrumento.CORDAS,
                "Contrabaixo",
                "Gibson Thunderbird",
                "GB77665544",
                1995,
                "Canadá",
                "RESTAURADO",
                "Braço inteiriço, captadores humbucker ativos",
                1L
        );

        var salaMock = new Sala();

        when(salaRepository.existsById(1L)).thenReturn(true);
        when(salaRepository.getReferenceById(1L)).thenReturn(salaMock);

        var instrumentoSalvo = new Instrumento(dadosCadastro, salaMock);

        org.springframework.test.util.ReflectionTestUtils.setField(instrumentoSalvo, "id", 1L);

        when(instrumentoRepository.save(any())).thenReturn(instrumentoSalvo);

        var response = mvc
                .perform(post("/instrumentos")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(dadosCadastroInstrumentoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        var dadosDetalhamento = new DadosDetalhamentoInstrumento(
                null,
                dadosCadastro.tipoInstrumento(),
                dadosCadastro.nome(),
                dadosCadastro.modelo(),
                dadosCadastro.numeroSerie(),
                dadosCadastro.anoFabricacao(),
                dadosCadastro.paisOrigem(),
                dadosCadastro.estadoConservacao(),
                dadosCadastro.caracteristica(),
                null
        );
        var jsonEsperado = dadosDetalhamentoInstrumentoJson.write(dadosDetalhamento).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    @Test
    @DisplayName("Deveria devolver 200 ao atualizar dados válidos")
    @WithMockUser(roles = "ADMINISTRADOR")
    void atualizar_DeveRetornar200() throws Exception {
        var dadosAtualizacao = new DadosAtualizacaoInstrumento(
                1L,
                TipoInstrumento.CORDAS,
                "Baixo",
                "Jazz Bass",
                "SN123",
                2020,
                "EUA",
                "NOVO",
                "Ativo",
                1L
        );
        var salaMock = new Sala();

        when(salaRepository.existsById(1L)).thenReturn(true);
        when(salaRepository.getReferenceById(1L)).thenReturn(salaMock);

        // Mockando o comportamento do Repository
        var instrumentoExistente = new Instrumento(
                new DadosCadastroInstrumento(
                        TipoInstrumento.CORDAS,
                        "Baixo",
                        "Jazz Bass",
                        "SN123",
                        2020,
                        "EUA",
                        "NOVO",
                        "Ativo",
                        1L
                ),
                salaMock
        );

        org.springframework.test.util.ReflectionTestUtils.setField(instrumentoExistente, "id", 1L);

        when(instrumentoRepository.getReferenceById(1L)).thenReturn(instrumentoExistente);

        var response = mvc.perform(put("/instrumentos")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(dadosAtualizacaoInstrumentoJson.write(dadosAtualizacao).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deveria devolver 204 ao excluir com sucesso")
    @WithMockUser(roles = "ADMINISTRADOR")
    void excluir_DeveRetornar204() throws Exception {
        var instrumento = new Instrumento();
        when(instrumentoRepository.findById(1L)).thenReturn(Optional.of(instrumento));

        var response = mvc.perform(delete("/instrumentos/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    @Test
    @DisplayName("Deveria devolver 404 ao tentar excluir instrumento inexistente")
    @WithMockUser(roles = "ADMINISTRADOR")
    void excluir_DeveRetornar404() throws Exception {
        when(instrumentoRepository.findById(1L)).thenReturn(Optional.empty());

        var response = mvc.perform(delete("/instrumentos/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    @DisplayName("Deveria devolver 200 ao detalhar instrumento")
    @WithMockUser
    void detalhar_DeveRetornar200() throws Exception {
        var salaMock = new Sala();

        org.springframework.test.util.ReflectionTestUtils.setField(salaMock, "id", 1L);
        when(salaRepository.existsById(1L)).thenReturn(true);
        when(salaRepository.getReferenceById(1L)).thenReturn(salaMock);

        var instrumento = new Instrumento();

        org.springframework.test.util.ReflectionTestUtils.setField(instrumento, "id", 1L);
        org.springframework.test.util.ReflectionTestUtils.setField(instrumento, "sala_fixa_id", salaMock);

        when(instrumentoRepository.findAllById(1L)).thenReturn(instrumento);

        var response = mvc.perform(get("/instrumentos/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deveria devolver 200 ao listar instrumentos")
    @WithMockUser
    void listar_DeveRetornar200() throws Exception {
        when(instrumentoRepository.findAll(any(Pageable.class))).thenReturn(Page.empty());

        var response = mvc.perform(get("/instrumentos"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deveria devolver 200 ao listar instrumentos e reservas")
    @WithMockUser
    void listarInstrumentoReserva_DeveRetornar200() throws Exception {
        var dadosBusca = new DadosListagemInstrumentoReserva(java.time.LocalDateTime.now(), java.time.LocalDateTime.now().plusHours(2));

        when(instrumentoRepository.findAllAndReserva(any(), any(), any())).thenReturn(Page.empty());

        var response = mvc.perform(get("/instrumentos/reservas")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(dadosListagemReservaJson.write(dadosBusca).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}