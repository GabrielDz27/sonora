package senior.godev.sonora.models.membro.formatacao;

import senior.godev.sonora.models.membro.Membro;
import senior.godev.sonora.models.membro.endereco.Endereco;

import java.time.LocalDate;

public record DadosDetalhamentoMembro(
        Long id,
        String login,
        String cpf,
        LocalDate data_nascimento,
        String nome,
        String email,
        Endereco endereco
) {
    public DadosDetalhamentoMembro(Membro membro, String loginUsuario) {
        this(
                membro.getId(),
                loginUsuario,
                membro.getCpf(),
                membro.getData_nascimento(),
                membro.getNome(),
                membro.getEmail(),
                membro.getEndereco()
        );
    }
}
