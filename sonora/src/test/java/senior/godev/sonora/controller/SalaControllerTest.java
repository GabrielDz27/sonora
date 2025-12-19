package senior.godev.sonora.controller;

import org.junit.jupiter.api.DisplayName;
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
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.models.sala.dto.DadosAtualizacaoSala;
import senior.godev.sonora.models.sala.dto.DadosCadastroSala;
import senior.godev.sonora.models.sala.dto.DadosDetalhamentoSala;
import senior.godev.sonora.models.sala.dto.DadosListagemSalaReserva;
import senior.godev.sonora.repository.SalaRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class SalaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroSala> dadosCadastroSalaJson;

    @Autowired
    private JacksonTester<DadosAtualizacaoSala> jacksonTesterAtualizacao;

    @Autowired
    private JacksonTester<DadosListagemSalaReserva> dadosListagemSalaReservaJson;

    @MockitoBean
    private SalaRepository salaRepository;

    @Test
    @DisplayName("Deveria devolver 201 ao cadastrar sala com dados válidos")
    @WithMockUser(roles = "ADMINISTRADOR")
    void cadastrar_CenarioSucesso() throws Exception {
        var dadosCadastro = new DadosCadastroSala("Sala 01", 30, true);
        var salaSalva = new Sala(dadosCadastro);
        setField(salaSalva, "id", 1L);

        when(salaRepository.save(any())).thenReturn(salaSalva);

        var response = mvc.perform(post("/salas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroSalaJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    @DisplayName("Deveria devolver 400 ao cadastrar sala com dados inválidos")
    @WithMockUser(roles = "ADMINISTRADOR")
    void cadastrar_CenarioErro() throws Exception {
        var response = mvc.perform(post("/salas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver 200 ao atualizar sala existente")
    @WithMockUser(roles = "ADMINISTRADOR")
    void atualizar_CenarioSucesso() throws Exception {
        var dadosAtualizacao = new DadosAtualizacaoSala(1L, "Sala 2", 10, true);
        var salaExistente = new Sala();
        setField(salaExistente, "id", 1L);

        when(salaRepository.existsById(1L)).thenReturn(true);
        when(salaRepository.getReferenceById(1L)).thenReturn(salaExistente);

        var response = mvc.perform(put("/salas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonTesterAtualizacao.write(dadosAtualizacao).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deveria devolver 400 ao atualizar sala que não existe")
    @WithMockUser(roles = "ADMINISTRADOR")
    void atualizar_CenarioSalaInexistente() throws Exception {
        when(salaRepository.existsById(1L)).thenReturn(false);

        var response = mvc.perform(put("/salas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"id\": 1, \"nome\": \"Sala VIP\", \"capacidade\": 10, \"temAbafadores\": true }"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria limpar reservas e instrumentos antes de excluir sala")
    @WithMockUser(roles = "ADMINISTRADOR")
    void excluir_CenarioSucessoComVinculos() throws Exception {
        var sala = new Sala();
        setField(sala, "id", 1L);
        setField(sala, "reservas", new java.util.ArrayList<>());
        setField(sala, "instrumentos", new java.util.ArrayList<>());

        when(salaRepository.findById(1L)).thenReturn(Optional.of(sala));

        when(salaRepository.findAllReservaById(1L)).thenReturn(java.util.List.of(new Reserva()));
        when(salaRepository.findAllInstrumentoById(1L)).thenReturn(java.util.List.of(new Instrumento()));

        var response = mvc.perform(delete("/salas/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
        verify(salaRepository).deleteById(1L);
    }

    @Test
    @DisplayName("Deveria lançar EntityNotFoundException quando sala não existe")
    @WithMockUser(roles = "ADMINISTRADOR")
    void excluir_CenarioSalaInexistente() throws Exception {
        when(salaRepository.findById(99L)).thenReturn(Optional.empty());

        var response = mvc.perform(delete("/salas/99"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    @DisplayName("Deveria devolver 404 ao detalhar sala inexistente")
    @WithMockUser
    void detalhar_CenarioNotFound() throws Exception {
        when(salaRepository.findAllAndInstrumentoById(99L)).thenReturn(Optional.empty());

        var response = mvc.perform(get("/salas/99"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    @DisplayName("Deveria devolver 409 ao tentar excluir sala com dependências no banco")
    @WithMockUser(roles = "ADMINISTRADOR")
    void excluir_CenarioConflito() throws Exception {
        var sala = new Sala();
        setField(sala, "id", 1L);

        when(salaRepository.findById(1L)).thenReturn(Optional.of(sala));
        doThrow(new DataIntegrityViolationException("Erro de integridade"))
                .when(salaRepository).deleteById(1L);

        var response = mvc.perform(delete("/salas/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value()); // 409
    }

    @Test
    @DisplayName("Deveria devolver 200 ao detalhar sala com sucesso")
    @WithMockUser
    void detalhar_CenarioSucesso() throws Exception {
        var projection = mock(senior.godev.sonora.repository.projections.SalaProjection.class);
        when(projection.getId()).thenReturn(1L);
        when(projection.getNome()).thenReturn("Sala Teste");
        when(projection.getCapacidade()).thenReturn(20);
        when(projection.getTem_Abafadores()).thenReturn(true);
        when(projection.getQuantidadeInstrumentos()).thenReturn(5L);
        when(projection.getNomesInstrumentos()).thenReturn("Piano, Violino");

        when(salaRepository.findAllAndInstrumentoById(1L)).thenReturn(Optional.of(projection));

        var response = mvc.perform(get("/salas/1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).contains("Sala Teste");
    }

    @Test
    @DisplayName("Deveria devolver 200 ao listar todas as salas")
    @WithMockUser
    void listar_CenarioSucesso() throws Exception {
        when(salaRepository.findAll(any(Pageable.class))).thenReturn(Page.empty());

        var response = mvc.perform(get("/salas"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deveria devolver 200 ao listar salas e reservas com filtro de data")
    @WithMockUser
    void listarSalasEReservas_CenarioSucesso() throws Exception {
        var dataInicio = java.time.LocalDateTime.now();
        var dataFim = dataInicio.plusHours(2);
        var dadosBusca = new DadosListagemSalaReserva(dataInicio, dataFim);

        when(salaRepository.findAllAndReserva(any(Pageable.class), any(), any()))
                .thenReturn(org.springframework.data.domain.Page.empty());

        var response = mvc.perform(get("/salas/reservas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosListagemSalaReservaJson.write(dadosBusca).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}