package senior.godev.sonora.models.instrumento.formatacao;

import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.instrumento.TipoInstrumento;

public record DadosListagemInstrumento(
        Long id,
        TipoInstrumento tipoInstrumento,
        String nome,
        String modelo
) {
    public DadosListagemInstrumento(Instrumento instrumento) {
        this(
                instrumento.getId(),
                instrumento.getTipoInstrumento(),
                instrumento.getNome(),
                instrumento.getModelo()
        );
    }
}
