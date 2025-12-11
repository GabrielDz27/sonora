package senior.godev.sonora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senior.godev.sonora.models.usuario.Usuario;
import senior.godev.sonora.repository.UsuarioRepository;

import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository userRepo;

    /**
     * @Login Aqui vai estar a informações gerais do usuario, nome, login, email, senha (hash) e classificação
     */
    @GetMapping("/info")
    public Usuario getUserDetails() {
        String userName = (String) Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        return userRepo.findByLogin(userName).get();
    }
}