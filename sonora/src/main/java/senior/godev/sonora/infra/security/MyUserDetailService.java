package senior.godev.sonora.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import senior.godev.sonora.models.usuario.Usuario;
import senior.godev.sonora.repository.UsuarioRepository;

import java.util.Collections;
import java.util.Optional;

@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByLogin(login);

        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Não foi encontrado o usuario com esse login: " + login);
        }

        Usuario user = usuario.get();
        
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getSenha(),
                Collections.singletonList(
                        new SimpleGrantedAuthority(user.getRole().name())
                )
        );
    }

}
