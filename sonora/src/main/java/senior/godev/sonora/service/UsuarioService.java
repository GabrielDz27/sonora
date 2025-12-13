package senior.godev.sonora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senior.godev.sonora.models.usuario.Usuario;
import senior.godev.sonora.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void atualizarSenha(String loginUsuario, String novaSenhaEmTextoPuro) {

        Usuario user = userRepo.findByLogin(loginUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        String senhaCriptografada = passwordEncoder.encode(novaSenhaEmTextoPuro);

        user.atualizarSenha(senhaCriptografada);
    }
}
