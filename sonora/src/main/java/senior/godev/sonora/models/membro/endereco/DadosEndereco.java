package senior.godev.sonora.models.membro.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "O logradouro é obrigatório")
        String logradouro,
        @NotBlank(message = "O bairro é ")
        String bairro,
        @NotBlank(message = "O cep é obrigatório")
        @Pattern(
                regexp = "\\d{8}",
                message = "Somente número e ter 8 digitos"
        )
        String cep,
        @NotBlank(message = "A cidade é obrigatório")
        String cidade,
        @NotBlank(message = " A UF é obrigatório")
        String uf,
        String complemento,
        String numero) {
}
