package senior.godev.sonora.models.instrumento.dto;

import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.instrumento.TipoInstrumento;

public record DadosDetalhamentoInstrumento(
        Long id,
        TipoInstrumento tipoInstrumento,
        String nome,
        String modelo,
        String numeroSerie,
        int anoFbricacao,
        String paisOrigem,
        String estadoConservacao,
        String caracteristica
) {
    public DadosDetalhamentoInstrumento(Instrumento instrumento) {
        this(
                instrumento.getId(),
                instrumento.getTipoInstrumento(),
                instrumento.getNome(),
                instrumento.getModelo(),
                instrumento.getNumeroSerie(),
                instrumento.getAnoFabricacao(),
                instrumento.getPaisOrigem(),
                instrumento.getEstadoConservacao(),
                instrumento.getCaracteristica()
        );
    }
}
