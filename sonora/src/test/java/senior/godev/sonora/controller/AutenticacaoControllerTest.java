package senior.godev.sonora.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import senior.godev.sonora.infra.security.JWTUtil;
import senior.godev.sonora.models.usuario.DadosCadastroUsuario;
import senior.godev.sonora.models.usuario.LoginCredenciais;
import senior.godev.sonora.models.usuario.Usuario;
import senior.godev.sonora.repository.UsuarioRepository;
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AutenticacaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroUsuario> dadosCadastroUsuarioJson;

    @MockitoBean
    private UsuarioRepository usuarioRepository;

    @MockitoBean
    private JWTUtil jwtUtil;

    @MockitoBean
    private AuthenticationManager authenticationManager;

    @MockitoBean
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando as informacoes sao validas")
    @WithMockUser
    void registerHandler_Dar200() throws Exception {
        var dadosCadastroUsuario = new DadosCadastroUsuario(
                "Leticia",
                "#Letic2",
                "gabriel.df27@aluno.ifsc.edu.br"
        );

        String tokenFake = "token-fake-123";

        when(passwordEncoder.encode(anyString())).thenReturn("senha_criptografada");
        when(usuarioRepository.save(any())).thenReturn(new Usuario(dadosCadastroUsuario));
        when(jwtUtil.gerarToken(anyString())).thenReturn(tokenFake);

        var response = mvc
                .perform(post("/auth/register")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(dadosCadastroUsuarioJson.write(dadosCadastroUsuario).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        String jsonEsperado = "{\"jwt-token\":\"" + tokenFake + "\"}";
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void registerHandler_Dar400() throws Exception {
        var response = mvc
                .perform(post("/auth/register"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando for fazer o login")
    @WithMockUser
    void loginHandler_Dar200() throws Exception {
        var loginDados = new LoginCredenciais("usuario@email.com", "senha123");
        String tokenFake = "token-fake-login";

        var auth = new UsernamePasswordAuthenticationToken(loginDados.login(), null);
        when(authenticationManager.authenticate(any())).thenReturn(auth);

        when(jwtUtil.gerarToken(loginDados.login())).thenReturn(tokenFake);

        var response = mvc
                .perform(post("/auth/login")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(new ObjectMapper().writeValueAsString(loginDados)))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).contains(tokenFake);
    }

    @Test
    @DisplayName("Deveria devolver codigo http 401 quando for fazer o login, credencias invalidas")
    @WithMockUser
    void loginHandler_Dar401() throws Exception {
        var loginDados = new LoginCredenciais("errado@email.com", "senhaErrada");

        when(authenticationManager.authenticate(any()))
                .thenThrow(new BadCredentialsException("Invalido"));

        var response = mvc
                .perform(post("/auth/login")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(new ObjectMapper().writeValueAsString(loginDados)))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.UNAUTHORIZED.value());
    }
}