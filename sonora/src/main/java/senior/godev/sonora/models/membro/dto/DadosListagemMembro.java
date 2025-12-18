package senior.godev.sonora.models.membro.dto;

public record DadosListagemMembro(
        Long id,
        String login,
        String cpf,
        String nome,
        String email
) {
}
