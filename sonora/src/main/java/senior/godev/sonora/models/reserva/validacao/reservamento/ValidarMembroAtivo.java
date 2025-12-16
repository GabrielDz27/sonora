package senior.godev.sonora.models.reserva.validacao.reservamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.reserva.dto.DadosCadastroReserva;
import senior.godev.sonora.repository.MembroRepository;

@Component
public class ValidarMembroAtivo implements ValidadorReservamento {

    @Autowired
    private MembroRepository membroRepository;

    @Override
    public void validar(DadosCadastroReserva dadosCadastroReserva) {


        var membroAtivo = membroRepository.findAtivoById(dadosCadastroReserva.idMembro());
        if (!membroAtivo) {
            throw new ValidacaoException("A reserva não pode ser realizada com um membro excluido");
        }
    }
}
