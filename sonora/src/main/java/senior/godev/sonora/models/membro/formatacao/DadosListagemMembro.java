package senior.godev.sonora.models.membro.formatacao;

public record DadosListagemMembro(
        Long id,
        String login,
        String cpf,
        String nome,
        String email
) {
}
