package senior.godev.sonora.models.reserva.dto;

import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.reserva.TipoUso;

import java.time.LocalDateTime;

public record DadosListagemReserva(
  Long id,
  Long idSala,
  String nomeInstrumento,
  Long idMembro,
  LocalDateTime dataHoraInicio,
  LocalDateTime dataHoraFinal,
  LocalDateTime dataHoraRegistro,
  TipoUso tipoUso,
  String emEspera
) {
  public DadosListagemReserva(Reserva reserva, String emEspera) {
    this(
      reserva.getId(),
      reserva.getSala().getId(),
      (reserva.getInstrumento() != null ? reserva.getInstrumento().getNome() : ""),
      reserva.getMembro().getId(),
      reserva.getDataHoraInicio(),
      reserva.getDataHoraFim(),
      reserva.getDataHoraRegistro(),
      reserva.getTipoUso(),
      emEspera
    );
  }
}
