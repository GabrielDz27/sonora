package senior.godev.sonora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.reserva.MotivoCancelamento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.reserva.dto.*;
import senior.godev.sonora.models.reserva.validacao.cancelamento.ValidadorCancelamento;
import senior.godev.sonora.models.reserva.validacao.confirmacao.ValidadorConfirmacao;
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
  private List<ValidadorConfirmacao> validadorConfirmacoes;

  @Autowired
  private List<ValidadorCancelamento> validadorCancelamentos;

  private EmailService emailService;

  @Autowired
  public void setEmailService(EmailService emailService) {
    this.emailService = emailService;
  }

  public DadosDetalhamentoReserva reservar(DadosCadastroReserva dadosCadastroReserva) {
    if (!salaRepository.existsById(dadosCadastroReserva.idSala())) {
      throw new ValidacaoException("Id da sala não existe");
    }

    if (dadosCadastroReserva.idInstrumento() != null &&
      !instrumentoRepository.existsById(dadosCadastroReserva.idInstrumento())
    ) {
      throw new ValidacaoException("Id da instrumento não existe");
    }

    if (!membroRepository.existsById(dadosCadastroReserva.idMembro())) {
      throw new ValidacaoException("Id do membro não existe");
    }

    validadores.forEach(v -> v.validar(dadosCadastroReserva));

    boolean emEspera = Boolean.TRUE.equals(reservaRepository.existsByDataHoraInicioAndDataHoraFimMotivoCancelamentoIsNull(dadosCadastroReserva.idSala(), dadosCadastroReserva.dataHoraInicio(), dadosCadastroReserva.dataHoraFim()));

    var instrumento = new Instrumento();
    if (dadosCadastroReserva.idInstrumento() != null) {
      instrumento = instrumentoRepository.findAllById(dadosCadastroReserva.idInstrumento());
    } else {
      instrumento = null;
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
    reservaRepository.save(reserva);

    return new DadosDetalhamentoReserva(reserva, (reserva.getEmEspera() == true ? "Na fila de espera" : "Reservado"));
  }


  public void cancelar(DadosCancelamentoReserva dados) {
    if (!reservaRepository.existsById(dados.idReserva())) {
      throw new ValidacaoException("Id da reserva informado não existe!");
    }

    validadorCancelamentos.forEach(v -> v.validar(dados));

    var reserva = reservaRepository.getReferenceById(dados.idReserva());
    reserva.cancelar(dados.motivo());
    proximoPromocao(reserva);

  }

  public void confirmar(DadosConfirmacaoReserva dadosCadastroReserva) {
    if (!reservaRepository.existsById(dadosCadastroReserva.id())) {
      throw new ValidacaoException("Id da reserva informado não existe!");
    }
    validadorConfirmacoes.forEach(validadorConfirmacao -> validadorConfirmacao.validar(dadosCadastroReserva));

    var reserva = reservaRepository.getReferenceById(dadosCadastroReserva.id());

    reserva.confirmar();
  }

  @Transactional
  public void preCancelamento(Reserva reserva, MotivoCancelamento esquecimentoConfirmacao) {
    reserva.cancelar(esquecimentoConfirmacao);
  }

  @Transactional
  public void cancelamentoFinalEPromocao(Reserva reserva, MotivoCancelamento motivo) {

    reserva.cancelar(motivo);
    reservaRepository.save(reserva);

    // 2. Promove o próximo da fila (se houver)
    proximoPromocao(reserva);
  }

  public void proximoPromocao(Reserva reserva) {
    var proximoOptional = reservaRepository.findProximoEmEspera(reserva.getSala().getId(), reserva.getDataHoraInicio());

    if (proximoOptional.isPresent()) {
      proximoOptional.get().setMotivoCancelamento(MotivoCancelamento.PENDENTE_CONFIRMACAO);
      reservaRepository.save(proximoOptional.get());

      emailService.enviarEmailConfirmacaoPromocao(proximoOptional.get());
    }
  }

  public Page<DadosListagemReserva> listagem(Pageable paginacao) {
    return reservaRepository.findAll(paginacao).map(r -> new DadosListagemReserva(r, (r.getEmEspera() == true ? "Na fila de espera" : "Reservado")));
  }

  public Page<DadosListagemReserva> listagemMembro(Long idMembro, Pageable paginacao) {
    return reservaRepository.findAllByMembroIdAndMotivoCancelamentoIsNull(idMembro, paginacao).map(r -> new DadosListagemReserva(r, (r.getEmEspera() == true ? "Na fila de espera" : "Reservado")));
  }
}
