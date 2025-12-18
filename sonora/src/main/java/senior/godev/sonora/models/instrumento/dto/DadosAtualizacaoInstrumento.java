package senior.godev.sonora.models.instrumento.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import senior.godev.sonora.models.instrumento.TipoInstrumento;

public record DadosAtualizacaoInstrumento(
        @NotNull(message = "o id é obrigatório")
        Long id,

        @Enumerated(EnumType.STRING)
        @NotNull
        TipoInstrumento tipoInstrumento,

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 1, max = 100)
        String nome,

        @NotBlank(message = "O modelo é obrigatório")
        @Size(min = 1, max = 100)
        String modelo,

        @Size(max = 100)
        String numeroSerie,

        @Positive(message = "O ano tem que ser positivo")
        int anoFabricacao,

        @NotBlank(message = "O pais de origem é obrigatório")
        @Size(min = 1, max = 100)
        String paisOrigem,

        @NotBlank(message = "O estado de conservação é obrigatório")
        @Size(min = 1, max = 50)
        String estadoConservacao,

        @NotBlank(message = "A caracteristica é obrigatória")
        @Size(min = 1, max = 255)
        String caracteristica,

        @NotNull(message = "O id da sala é obrigatorio")
        Long idSala
) {
}
