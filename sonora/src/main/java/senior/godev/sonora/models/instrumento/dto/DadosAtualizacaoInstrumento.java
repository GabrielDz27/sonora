package senior.godev.sonora.models.instrumento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import senior.godev.sonora.models.instrumento.TipoInstrumento;

public record DadosAtualizacaoInstrumento(
        @NotNull(message = "o id é obrigatório")
        Long id,

        TipoInstrumento tipoInstrumento,

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O modelo é obrigatório")
        String modelo,

        String numeroSerie,

        @Past(message = "O ano tem que ser antes da data atual")
        @Positive(message = "O ano tem que ser positivo")
        int anoFabricacao,

        @NotBlank(message = "O pais de origem é obrigatório")
        String paisOrigem,

        @NotBlank(message = "O estado de conservação é obrigatório")
        String estadoConservacao,

        @NotBlank(message = "A caracteristica é obrigatória")
        String caracteristica
) {
}
