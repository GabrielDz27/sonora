package senior.godev.sonora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import senior.godev.sonora.models.usuario.DadosAtualizacaoSenhaUsuario;
import senior.godev.sonora.models.usuario.Usuario;
import senior.godev.sonora.repository.UsuarioRepository;
import senior.godev.sonora.service.UsuarioService;

import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private UsuarioService usuarioService;

    /**
     * @Usuario
     * @Login Aqui vai estar a informações gerais do usuario, nome, login, email, senha (hash) e classificação
     */
    @GetMapping("/info")
    public Usuario getUserDetails() {
        String userName = (String) Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        return userRepo.findByLogin(userName).get();
    }

    /**
     * @Usuario Possibilita o usuario atualizar a senha
     */
    @PutMapping("/senha")
    public ResponseEntity atualizarSenha(@RequestBody DadosAtualizacaoSenhaUsuario dadosAtualizacao) {
        String loginUsuario = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usuarioService.atualizarSenha(loginUsuario, dadosAtualizacao.senha());

        return ResponseEntity.ok("Senha atualizada com sucesso.");
    }
}