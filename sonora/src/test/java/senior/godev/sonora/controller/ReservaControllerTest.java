package senior.godev.sonora.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import senior.godev.sonora.models.reserva.MotivoCancelamento;
import senior.godev.sonora.models.reserva.TipoUso;
import senior.godev.sonora.models.reserva.dto.DadosCadastroReserva;
import senior.godev.sonora.models.reserva.dto.DadosCancelamentoReserva;
import senior.godev.sonora.models.reserva.dto.DadosConfirmacaoReserva;
import senior.godev.sonora.service.ReservaService;

import java.time.LocalDateTime;
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
class ReservaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private ReservaService reservaService;

    @Autowired
    private JacksonTester<DadosCadastroReserva> dadosCadastroReservaJson;

    @Autowired
    private JacksonTester<DadosCancelamentoReserva> dadosCancelamentoReservaJson;

    @Autowired
    private JacksonTester<DadosConfirmacaoReserva> dadosConfirmacaoReservaJson;

    @Test
    @DisplayName("Deveria devolver 200 ao efetuar reserva com dados validos")
    @WithMockUser
    void reserva_CenarioSucesso() throws Exception {
        var dados = new DadosCadastroReserva(
                1L,
                1L,
                1L,
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(2),
                TipoUso.AULA,
                "Primeira aula"
        );

        when(reservaService.reservar(any())).thenReturn(null);

        var response = mvc.perform(post("/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroReservaJson.write(dados).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deveria devolver 204 ao cancelar reserva")
    @WithMockUser
    void cancelar_CenarioSucesso() throws Exception {
        var dados = new DadosCancelamentoReserva(1L, MotivoCancelamento.AULA_CANCELADA);

        var response = mvc.perform(delete("/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCancelamentoReservaJson.write(dados).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
        verify(reservaService).cancelar(any());
    }

    @Test
    @DisplayName("Deveria devolver 204 ao confirmar reserva")
    @WithMockUser
    void confirmar_CenarioSucesso() throws Exception {
        var dados = new DadosConfirmacaoReserva(1L);

        var response = mvc.perform(post("/reserva/confirmar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosConfirmacaoReservaJson.write(dados).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
        verify(reservaService).confirmar(any());
    }

    @Test
    @DisplayName("Deveria devolver 200 ao listar reservas como administrador")
    @WithMockUser(roles = "ADMINISTRADOR")
    void listar_CenarioSucesso() throws Exception {
        when(reservaService.listagem(any())).thenReturn(Page.empty());

        var response = mvc.perform(get("/reserva"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("Deveria devolver 403 ao tentar listar reservas sem ser administrador")
    @WithMockUser(roles = "USUARIO") // Role diferente do exigido
    void listar_CenarioErroSeguranca() throws Exception {
        var response = mvc.perform(get("/reserva"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.FORBIDDEN.value());
    }
}