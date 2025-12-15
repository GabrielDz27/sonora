package senior.godev.sonora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.reserva.formatacao.DadosCadastroReserva;
import senior.godev.sonora.models.reserva.formatacao.DadosCancelamentoReserva;
import senior.godev.sonora.models.reserva.formatacao.DadosConfirmacaoReserva;
import senior.godev.sonora.models.reserva.formatacao.DadosDetalhamentoReserva;
import senior.godev.sonora.models.reserva.validacao.cancelamento.ValidadorCancelamento;
import senior.godev.sonora.models.reserva.validacao.reservamento.ValidadorReservamento;
import senior.godev.sonora.repository.InstrumentoRepository;
import senior.godev.sonora.repository.MembroRepository;
import senior.godev.sonora.repository.ReservaRepository;
import senior.godev.sonora.repository.SalaRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private List<ValidadorReservamento> validadores;

    @Autowired
    private List<ValidadorCancelamento> validadoresCancelamento;

    public DadosDetalhamentoReserva reservar(DadosCadastroReserva dadosCadastroReserva) {
        if (!salaRepository.existsById(dadosCadastroReserva.idSala())) {
            throw new ValidacaoException("Id da sala não existe");
        }

        if (dadosCadastroReserva.idInstrumento() != null &&
                !instrumentoRepository.existsById(dadosCadastroReserva.idInstrumento())
        ) {
            throw new ValidacaoException("Id da instrumento não existe");
        }

        if (membroRepository.existsById(dadosCadastroReserva.idMembro())) {
            throw new ValidacaoException("Id do membro não existe");
        }

        validadores.forEach(v -> v.validar(dadosCadastroReserva));

        boolean emEspera = reservaRepository.existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNull(dadosCadastroReserva.dataHoraInicio(), dadosCadastroReserva.dataHoraFim());

        var instrumento = new Instrumento();
        if (dadosCadastroReserva.idInstrumento() != null) {
            instrumento = instrumentoRepository.findAllById(dadosCadastroReserva.idInstrumento());
        }

        var membro = membroRepository.findAllById(dadosCadastroReserva.idMembro());
        var sala = salaRepository.findAllById(dadosCadastroReserva.idSala());

        var reserva = new Reserva(
                null,
                sala,
                instrumento,
                membro,
                dadosCadastroReserva.dataHoraInicio(),
                dadosCadastroReserva.dataHoraFim(),
                LocalDateTime.from(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))),
                emEspera,
                dadosCadastroReserva.tipoUso(),
                dadosCadastroReserva.observacoes(),
                null
        );

        return new DadosDetalhamentoReserva(reserva, (reserva.getEmEspera() == true ? "Na fila de espera" : "Reservado"));
    }


    public void cancelar(DadosCancelamentoReserva dados) {
        if (!reservaRepository.existsById(dados.idReserva())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));

        var reserva = reservaRepository.getReferenceById(dados.idReserva());
        reserva.cancelar(dados.motivo());
    }

    public void confirmar(DadosConfirmacaoReserva dadosCadastroReserva) {

    }
}
