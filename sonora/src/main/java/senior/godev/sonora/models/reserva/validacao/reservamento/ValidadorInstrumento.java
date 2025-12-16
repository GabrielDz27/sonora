package senior.godev.sonora.models.reserva.validacao.reservamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.reserva.formatacao.DadosCadastroReserva;
import senior.godev.sonora.repository.InstrumentoRepository;

@Component("ValidadorInstrumentoReservamento")
public class ValidadorInstrumento implements ValidadorReservamento {

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @Override
    public void validar(DadosCadastroReserva dadosCadastroReserva) {

        if (instrumentoRepository.instrumentoReservado(dadosCadastroReserva.idInstrumento(), dadosCadastroReserva.dataHoraInicio(), dadosCadastroReserva.dataHoraFim())) {
            throw new ValidacaoException("O instrumento selecionado está reservado");
        }
    }
}
