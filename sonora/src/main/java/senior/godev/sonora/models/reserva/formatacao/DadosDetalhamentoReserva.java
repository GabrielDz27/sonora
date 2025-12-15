package senior.godev.sonora.models.reserva.formatacao;

import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.reserva.TipoUso;

import java.time.LocalDateTime;

public record DadosDetalhamentoReserva(
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
    public DadosDetalhamentoReserva(Reserva reserva, String emEspera) {
        this(
                reserva.getId(),
                reserva.getSala().getId(),
                reserva.getInstrumento().getNome(),
                reserva.getMembro().getId(),
                reserva.getDataHoraInicio(),
                reserva.getDataHoraFim(),
                reserva.getDataHoraRegistro(),
                reserva.getTipoUso(),
                emEspera
        );
    }
}
