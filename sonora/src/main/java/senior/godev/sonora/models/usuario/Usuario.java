package senior.godev.sonora.models.usuario;

import jakarta.persistence.*;
import lombok.*;
import senior.godev.sonora.models.membro.Membro;

import java.util.List;
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

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Membro> membros;

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

    public void removeMembro(Membro membro) {
        membros.remove(membro);
        membro.setUsuario(null);
    }
}
