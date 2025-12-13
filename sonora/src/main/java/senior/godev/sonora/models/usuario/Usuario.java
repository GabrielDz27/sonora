package senior.godev.sonora.models.usuario;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String login;

    private String senha;

    private String email;

    @Enumerated(EnumType.STRING)
    private IdentificacaoUsuario role;

    public Usuario(DadosCadastroUsuario dados) {
        this.login = dados.login();
        this.senha = dados.senha();
        this.email = dados.email();
        this.role = dados.role();
    }

    public void atualizarEmail(String email) {
        this.email = email;
    }

    public void atualizarSenha(String senha) {
        this.senha = senha;
    }
}
