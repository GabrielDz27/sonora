package senior.godev.sonora.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.dao.DataIntegrityViolationException;
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
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.repository.InstrumentoRepository;
import senior.godev.sonora.repository.SalaRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.ReflectionTestUtils.setField;
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
    @WithMockUser(roles = "ADMINISTRADOR")
    void cadastrar_DeveRetornar400() throws Exception {
        var response = mvc
                .perform(post("/instrumentos"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver 400 quando sala não existe no cadastro")
    @WithMockUser(roles = "ADMINISTRADOR")
    void cadastrar_CenarioSalaInexistente() throws Exception {
        var dadosCadastro = new DadosCadastroInstrumento(
                TipoInstrumento.CORDAS, "Teste", "Modelo", "123", 2024, "BR", "NOVO", "Obs", 99L
        );

        when(salaRepository.existsById(99L)).thenReturn(false);

        var response = mvc.perform(post("/instrumentos")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(dadosCadastroInstrumentoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser(roles = "ADMINISTRADOR")
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

        setField(instrumentoSalvo, "id", 1L);

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

        setField(instrumentoExistente, "id", 1L);

        when(instrumentoRepository.getReferenceById(1L)).thenReturn(instrumentoExistente);

        var response = mvc.perform(put("/instrumentos")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(dadosAtualizacaoInstrumentoJson.write(dadosAtualizacao).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deveria devolver 400 quando sala não existe na atualização")
    @WithMockUser(roles = "ADMINISTRADOR")
    void atualizar_CenarioSalaInexistente() throws Exception {
        var dadosAtualizacao = new DadosAtualizacaoInstrumento(
                1L,
                TipoInstrumento.CORDAS,
                "Nome",
                "Mod",
                "SN",
                2020,
                "BR",
                "VELHO",
                "Obs",
                99L
        );

        when(salaRepository.existsById(99L)).thenReturn(false);

        var response = mvc.perform(put("/instrumentos")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(dadosAtualizacaoInstrumentoJson.write(dadosAtualizacao).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria atualizar sala do instrumento quando forem diferentes")
    @WithMockUser(roles = "ADMINISTRADOR")
    void atualizar_DeveTrocarSalaQuandoDiferente() throws Exception {
        var dados = new DadosAtualizacaoInstrumento(1L, TipoInstrumento.CORDAS, "N", "M", "S", 2020, "P", "E", "C", 2L);

        Sala salaAntiga = new Sala();
        setField(salaAntiga, "id", 1L);

        setField(salaAntiga, "instrumentos", new ArrayList<>());

        Sala salaNova = new Sala();
        setField(salaNova, "id", 2L);

        setField(salaNova, "instrumentos", new ArrayList<>());

        Instrumento instrumento = new Instrumento();
        setField(instrumento, "id", 1L);
        setField(instrumento, "sala_fixa_id", salaAntiga);

        when(salaRepository.existsById(2L)).thenReturn(true);
        when(instrumentoRepository.getReferenceById(1L)).thenReturn(instrumento);
        when(salaRepository.getReferenceById(2L)).thenReturn(salaNova);

        var response = mvc.perform(put("/instrumentos")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(dadosAtualizacaoInstrumentoJson.write(dados).getJson()))
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
    @DisplayName("Deveria devolver 409 ao ocorrer violação de integridade na exclusão")
    @WithMockUser(roles = "ADMINISTRADOR")
    void excluir_CenarioConflitoIntegridade() throws Exception {
        var instrumento = new Instrumento();
        when(instrumentoRepository.findById(1L)).thenReturn(Optional.of(instrumento));

        doThrow(new DataIntegrityViolationException("Erro de integridade"))
                .when(instrumentoRepository).deleteById(any());

        var response = mvc.perform(delete("/instrumentos/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value()); // 409
    }

    @Test
    @DisplayName("Deveria percorrer a lista de reservas ao excluir um instrumento")
    @WithMockUser(roles = "ADMINISTRADOR")
    void excluir_DeveRemoverReservasAntesDeDeletar() throws Exception {

        var instrumento = new Instrumento();
        setField(instrumento, "id", 1L);

        setField(instrumento, "reservas", new java.util.ArrayList<>());

        var reservaMock = new Reserva();
        var listaReservas = java.util.List.of(reservaMock);

        when(instrumentoRepository.findById(1L)).thenReturn(Optional.of(instrumento));
        when(instrumentoRepository.findAllReservaById(1L)).thenReturn(listaReservas);

        var response = mvc.perform(delete("/instrumentos/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
        verify(instrumentoRepository).deleteById(1L);
    }

    @Test
    @DisplayName("Deveria devolver 200 ao detalhar instrumento")
    @WithMockUser
    void detalhar_DeveRetornar200() throws Exception {
        var salaMock = new Sala();

        setField(salaMock, "id", 1L);
        when(salaRepository.existsById(1L)).thenReturn(true);
        when(salaRepository.getReferenceById(1L)).thenReturn(salaMock);

        var instrumento = new Instrumento();

        setField(instrumento, "id", 1L);
        setField(instrumento, "sala_fixa_id", salaMock);

        when(instrumentoRepository.findAllById(1L)).thenReturn(instrumento);

        var response = mvc.perform(get("/instrumentos/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deveria retornar 404 quando EntityNotFoundException ocorre dentro do bloco try")
    @WithMockUser(roles = "ADMINISTRADOR")
    void excluir_CenarioErroInesperadoNoTry() throws Exception {

        var instrumento = new Instrumento();
        setField(instrumento, "id", 1L);

        when(instrumentoRepository.findById(1L)).thenReturn(Optional.of(instrumento));

        when(instrumentoRepository.findAllReservaById(1L))
                .thenThrow(new jakarta.persistence.EntityNotFoundException("Erro interno"));

        var response = mvc.perform(delete("/instrumentos/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
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