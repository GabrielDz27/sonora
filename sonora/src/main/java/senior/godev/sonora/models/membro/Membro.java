package senior.godev.sonora.models.membro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import senior.godev.sonora.models.membro.endereco.Endereco;
import senior.godev.sonora.models.membro.formatacao.DadosAtualizacaoMembro;
import senior.godev.sonora.models.membro.formatacao.DadosCadastroMembro;
import senior.godev.sonora.utils.ValidadorCpf;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "membros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID usuario_id;

    private String cpf;
    private LocalDate data_nascimento;
    private String nome;
    private String email;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Membro(DadosCadastroMembro dadosCadastroMembro, UUID usuarioId, String usuarioEmail) {
        ValidadorCpf validadorCpf = new ValidadorCpf();

        if (!validadorCpf.validarCpf(dadosCadastroMembro.cpf())) {
            throw new RuntimeException("Cpf invalido");
        }

        this.usuario_id = usuarioId;
        this.email = usuarioEmail;
        this.cpf = dadosCadastroMembro.cpf();
        this.data_nascimento = dadosCadastroMembro.data_nascimento();
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

        if (dadosAtualizacaoMembro.data_nascimento() != null) {
            this.data_nascimento = dadosAtualizacaoMembro.data_nascimento();
        }

        if (dadosAtualizacaoMembro.endereco() != null) {
            if (this.endereco == null) {
                this.endereco = new Endereco(dadosAtualizacaoMembro.endereco());
            } else {
                this.endereco.atualizarInformacoes(dadosAtualizacaoMembro.endereco());
            }
        }
    }
}
