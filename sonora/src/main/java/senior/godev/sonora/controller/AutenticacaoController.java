package senior.godev.sonora.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senior.godev.sonora.infra.security.JWTUtil;
import senior.godev.sonora.models.usuario.DadosCadastroUsuario;
import senior.godev.sonora.models.usuario.LoginCredenciais;
import senior.godev.sonora.models.usuario.Usuario;
import senior.godev.sonora.repository.UsuarioRepository;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private JWTUtil jwtUtil;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * @Endpoints
   * @Login Aqui vai ser registrado o usuario
   * vai devolver um token
   */
  @PostMapping("/register")
  public ResponseEntity registerHandler(@RequestBody @Valid DadosCadastroUsuario dados) {
    var usuario = new Usuario(dados);
    String encodedPassword = passwordEncoder.encode(usuario.getSenha());
    usuario.setSenha(encodedPassword);
    usuario = usuarioRepository.save(usuario);

    String token = jwtUtil.gerarToken(usuario);
    return ResponseEntity.ok(Collections.singletonMap("jwt-token", token));
  }

  /**
   * @Login Aqui vai ser efetuado o login
   * vai devolver um token
   */
  @PostMapping("/login")
  public Map<String, Object> loginHandler(@RequestBody @Valid LoginCredenciais usuario) {
    var authInputToken = new UsernamePasswordAuthenticationToken(usuario.login(), usuario.senha());
    authenticationManager.authenticate(authInputToken);

    var usuarioT = usuarioRepository.findByLogin(usuario.login());
    
    String token = jwtUtil.gerarToken(usuarioT.get());
    return Collections.singletonMap("jwt-token", token);
  }
}
