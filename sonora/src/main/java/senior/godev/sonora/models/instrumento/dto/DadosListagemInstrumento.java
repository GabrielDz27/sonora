package senior.godev.sonora.models.instrumento.dto;

import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.instrumento.TipoInstrumento;

public record DadosListagemInstrumento(
  Long id,
  TipoInstrumento tipoInstrumento,
  String numeroSerie,
  String nome,
  String modelo,
  int anoFabricacao,
  String paisOrigem,
  String salaFixaNome
) {
  public DadosListagemInstrumento(Instrumento instrumento) {
    this(
      instrumento.getId(),
      instrumento.getTipoInstrumento(),
      instrumento.getNumeroSerie(),
      instrumento.getNome(),
      instrumento.getModelo(),
      instrumento.getAnoFabricacao(),
      instrumento.getPaisOrigem(),
      instrumento.getSala_fixa_id().getNome()
    );
  }
}
