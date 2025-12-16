package senior.godev.sonora.models.membro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import senior.godev.sonora.models.membro.endereco.Endereco;
import senior.godev.sonora.models.membro.formatacao.DadosAtualizacaoMembro;
import senior.godev.sonora.models.membro.formatacao.DadosCadastroMembro;
import senior.godev.sonora.models.usuario.Usuario;
import senior.godev.sonora.utils.ValidadorCpf;

import java.time.LocalDate;

@Entity
@Table(name = "membros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private String cpf;
    private LocalDate dataNascimento;
    private String nome;
    private String email;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Membro(DadosCadastroMembro dadosCadastroMembro, Usuario usuario, String usuarioEmail) {
        ValidadorCpf validadorCpf = new ValidadorCpf();

        if (!validadorCpf.validarCpf(dadosCadastroMembro.cpf())) {
            throw new RuntimeException("Cpf invalido");
        }

        this.usuario = usuario;
        this.email = usuarioEmail;
        this.cpf = dadosCadastroMembro.cpf();
        this.dataNascimento = dadosCadastroMembro.dataNascimento();
        this.nome = dadosCadastroMembro.nome();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoMembro dadosAtualizacaoMembro) {
        if (dadosAtualizacaoMembro.cpf() != null) {
            ValidadorCpf validadorCpf = new ValidadorCpf();
            if (!validadorCpf.validarCpf(dadosAtualizacaoMembro.cpf())) {
                throw new RuntimeException("Novo CPF inválido.");
            }
            this.cpf = dadosAtualizacaoMembro.cpf();
        }

        if (dadosAtualizacaoMembro.nome() != null) {
            this.nome = dadosAtualizacaoMembro.nome();
        }

        if (dadosAtualizacaoMembro.dataNascimento() != null) {
            this.dataNascimento = dadosAtualizacaoMembro.dataNascimento();
        }

        if (dadosAtualizacaoMembro.endereco() != null) {
            if (this.endereco == null) {
                this.endereco = new Endereco(dadosAtualizacaoMembro.endereco());
            } else {
                this.endereco.atualizarInformacoes(dadosAtualizacaoMembro.endereco());
            }
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
