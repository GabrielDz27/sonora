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
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.membro.Membro;
import senior.godev.sonora.models.membro.dto.DadosAtualizacaoMembro;
import senior.godev.sonora.models.membro.dto.DadosCadastroMembro;
import senior.godev.sonora.models.membro.dto.DadosDetalhamentoMembro;
import senior.godev.sonora.models.membro.endereco.DadosEndereco;
import senior.godev.sonora.models.membro.endereco.Endereco;
import senior.godev.sonora.models.usuario.IdentificacaoUsuario;
import senior.godev.sonora.repository.MembroRepository;
import senior.godev.sonora.repository.UsuarioRepository;
import senior.godev.sonora.service.MembroService;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MembroControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockitoBean
  private MembroRepository membroRepository;

  @Autowired
  private JacksonTester<DadosCadastroMembro> cadastroMembroJacksonTester;

  @Autowired
  private JacksonTester<DadosDetalhamentoMembro> detalhamentoMembroJacksonTester;

  @Autowired
  private JacksonTester<DadosAtualizacaoMembro> atualizacaoMembroJacksonTester;

  @MockitoBean
  private UsuarioRepository usuarioRepository;

  @MockitoBean
  private MembroService membroService;

  private DadosEndereco dadosEndereco() {
    return new DadosEndereco(
      "rua xpto",
      "bairro",
      "00000000",
      "Brasilia",
      "DF",
      null,
      null
    );
  }

  @Test
  @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
  @WithMockUser(roles = "ADMINISTRADOR")
  void cadastrar_Dar200() throws Exception {

    var dadosCadastroMembro = new DadosCadastroMembro(
      "qualquer_c",
      "12345678909",
      LocalDate.of(2023, 01, 01),
      "Cleiton",
      "1234567890",
      IdentificacaoUsuario.ADMINISTRADOR,
      dadosEndereco()
    );

    var dadosDetalhamento = new DadosDetalhamentoMembro(
      null,
      dadosCadastroMembro.login(),
      dadosCadastroMembro.cpf(),
      dadosCadastroMembro.dataNascimento(),
      dadosCadastroMembro.nome(),
      "email.antigo@teste.com",
      "",
      IdentificacaoUsuario.ALUNO,
      new Endereco(dadosCadastroMembro.endereco())
    );

    when(membroService.cadastrar(any())).thenReturn(dadosDetalhamento);

    var response = mvc
      .perform(post("/membros")
        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
        .content(cadastroMembroJacksonTester.write(dadosCadastroMembro).getJson()))
      .andReturn().getResponse();

    var jsonEsperado = detalhamentoMembroJacksonTester.write(dadosDetalhamento).getJson();

    assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
  }

  @Test
  @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
  @WithMockUser(roles = "ADMINISTRADOR")
  void cadastrar_DeveRetornar400() throws Exception {
    var response = mvc
      .perform(post("/membros"))
      .andReturn().getResponse();

    assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
  }

  @Test
  @DisplayName("Deveria devolver codigo http 403 quando o acesso foi negado")
  @WithMockUser
  void cadastrar_DeveRetornar403() throws Exception {
    var response = mvc
      .perform(post("/membros"))
      .andReturn().getResponse();

    assertThat(response.getStatus()).isEqualTo(HttpStatus.FORBIDDEN.value());
  }

  @Test
  @DisplayName("Deveria atualizar o email do usuário vinculado ao membro")
  @WithMockUser(roles = "ADMINISTRADOR")
  void atualizarMembro_cenarioSucesso() throws Exception {

    var dadosAtualizacao = new DadosAtualizacaoMembro(
      1L,
      "qualquer_c",
      "12345678909",
      LocalDate.of(2023, 01, 01),
      "Cleiton",
      "novo.email@teste.com",
      "1234567890",
      IdentificacaoUsuario.ALUNO,
      dadosEndereco()
    );

    var dadosDetalhamento = new DadosDetalhamentoMembro(
      null,
      dadosAtualizacao.login(),
      dadosAtualizacao.cpf(),
      dadosAtualizacao.dataNascimento(),
      dadosAtualizacao.nome(),
      "novo.email@teste.com",
      "",
      IdentificacaoUsuario.ALUNO,
      new Endereco(dadosAtualizacao.endereco())
    );

    when(membroService.atualizarMembro(dadosAtualizacao)).thenReturn(dadosDetalhamento);

    var response = mvc.perform(put("/membros")
        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
        .content(atualizacaoMembroJacksonTester.write(dadosAtualizacao).getJson()))
      .andReturn().getResponse();

    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(response.getContentAsString()).contains("novo.email@teste.com");
  }

  @Test
  @DisplayName("Deveria devolver 200 ao detalhar membro")
  @WithMockUser(roles = "ADMINISTRADOR")
  void detalhar_DeveRetornar200() throws Exception {
    var membro = new Membro();
    when(membroRepository.findAllById(1L)).thenReturn(membro);

    var response = mvc.perform(get("/membros/1"))
      .andReturn().getResponse();

    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
  }

  @Test
  @DisplayName("Deveria devolver 200 ao listar membros")
  @WithMockUser(roles = "ADMINISTRADOR")
  void listar_DeveRetornar200() throws Exception {
    when(membroRepository.findAll(any(Pageable.class))).thenReturn(Page.empty());

    var response = mvc.perform(get("/membros"))
      .andReturn().getResponse();

    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
  }

  @Test
  @DisplayName("Deveria devolver 204 ao excluir com sucesso")
  @WithMockUser(roles = "ADMINISTRADOR")
  void excluir_DeveRetornar204() throws Exception {
    var membro = new Membro();
    when(membroRepository.findById(1L)).thenReturn(Optional.of(membro));

    var response = mvc.perform(delete("/membros/1"))
      .andReturn().getResponse();

    assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
  }

  @Test
  @DisplayName("Deveria devolver 400 ao tentar excluir membro inexistente")
  @WithMockUser(roles = "ADMINISTRADOR")
  void excluir_DeveRetornar400() throws Exception {

    doThrow(new ValidacaoException("Não foi encontrado o membro pra excluir."))
      .when(membroService).excluirMembro(1L);

    var response = mvc.perform(delete("/membros/1"))
      .andReturn().getResponse();

    assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
  }

}
