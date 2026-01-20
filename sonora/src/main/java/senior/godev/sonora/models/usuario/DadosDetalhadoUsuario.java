package senior.godev.sonora.models.usuario;

public record DadosDetalhadoUsuario(
  String email,
  String senha,
  String login
) {
  public DadosDetalhadoUsuario(Usuario usuario) {
    this(
      usuario.getEmail(),
      usuario.getSenha(),
      usuario.getLogin()
    );
  }
}
