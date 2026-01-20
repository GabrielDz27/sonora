package senior.godev.sonora.models.reserva.validacao.reservamento;

import org.springframework.stereotype.Component;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.reserva.dto.DadosCadastroReserva;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorReservamento {

  public void validar(DadosCadastroReserva dadosCadastroReserva) {
    var dataInicio = dadosCadastroReserva.dataHoraInicio();

    var domingo = dataInicio.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    var antesAbrir = dataInicio.getHour() < 7;
    var depoisFechar = dataInicio.getHour() > 18;
    var sabadoDepoisFechar = dataInicio.getDayOfWeek().equals(DayOfWeek.SATURDAY) && dataInicio.getHour() >= 13;

    if (domingo || antesAbrir || depoisFechar || sabadoDepoisFechar) {
      throw new ValidacaoException("A reservar esta fora do horário de funcionamento");
    }
  }
}
