package senior.godev.sonora.models.instrumento.formatacao;

import jakarta.validation.constraints.NotBlank;
import senior.godev.sonora.models.instrumento.TipoInstrumento;

public record DadosCadastroInstrumento(
        
        TipoInstrumento tipoInstrumento,

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O modelo é obrigatório")
        String modelo,

        String numero_serie,

        int ano_fabricacao,

        @NotBlank(message = "O pais de origem é obrigatório")
        String pais_origem,

        @NotBlank(message = "O estado de conservação é obrigatório")
        String estado_conservacao,

        @NotBlank(message = "A caracteristica é obrigatória")
        String caracteristica
) {
}
