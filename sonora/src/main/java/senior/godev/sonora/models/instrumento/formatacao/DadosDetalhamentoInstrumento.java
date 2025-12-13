package senior.godev.sonora.models.instrumento.formatacao;

import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.instrumento.TipoInstrumento;

public record DadosDetalhamentoInstrumento(
        Long id,
        TipoInstrumento tipoInstrumento,
        String nome,
        String modelo,
        String numero_serie,
        int ano_fabricacao,
        String pais_origem,
        String estado_conservacao,
        String caracteristica
) {
    public DadosDetalhamentoInstrumento(Instrumento instrumento) {
        this(
                instrumento.getId(),
                instrumento.getTipoInstrumento(),
                instrumento.getNome(),
                instrumento.getModelo(),
                instrumento.getNumero_serie(),
                instrumento.getAno_fabricacao(),
                instrumento.getPais_origem(),
                instrumento.getEstado_conservacao(),
                instrumento.getCaracteristica()
        );
    }
}
