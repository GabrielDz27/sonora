package senior.godev.sonora.models.instrumento.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import senior.godev.sonora.models.instrumento.TipoInstrumento;

public record DadosCadastroInstrumento(

        @Enumerated(EnumType.STRING)
        @NotNull
        TipoInstrumento tipoInstrumento,

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O modelo é obrigatório")
        String modelo,

        String numeroSerie,

        @Positive(message = "Ano deve ser positivo")
        int anoFabricacao,

        @NotBlank(message = "O pais de origem é obrigatório")
        String paisOrigem,

        @NotBlank(message = "O estado de conservação é obrigatório")
        String estadoConservacao,

        @NotBlank(message = "A caracteristica é obrigatória")
        String caracteristica,

        @NotNull(message = "Id da sala é obrigatorio")
        Long idSala
) {
}
