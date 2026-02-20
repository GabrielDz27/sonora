package br.com.senior.mydomain.myservice.services.registroproducao;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.Peca;
import br.com.senior.mydomain.myservice.RegistroProducao;
import br.com.senior.mydomain.myservice.RegistroProducaoCrudValidator;
import br.com.senior.mydomain.myservice.RegistroProducaoEntity;
import br.com.senior.mydomain.myservice.repositories.maquina.MaquinaRepository;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import br.com.senior.mydomain.myservice.repositories.registroproducao.RegistroProducaoRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RegistroProducaoCrudValidatorImpl implements RegistroProducaoCrudValidator {

    @Inject
    private static MaquinaRepository maquinaRepository;

    @Inject
    private static PecaRepository pecaRepository;

    @Inject
    private static RegistroProducaoRepository registroProducaoRepository;

    private static void validadorPeca(UUID idPeca) {
        if (pecaRepository.isPecaStatusNotPendente(idPeca)) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, "A peça não está disponivel para trabalhar");
        }
    }

    private static void validadorMaquina(UUID idMaquina) {
        if (maquinaRepository.isMaquinaStatusNotAtiva(idMaquina)) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, "A maquina não está ativa");
        }

        if (registroProducaoRepository.isMaquinaUsada(LocalDateTime.now(), idMaquina)) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, "A maquina já esta sendo usada");
        }
    }

    @Override
    public void beforeCreate(RegistroProducaoEntity entity) {
        validadorPeca(entity.getPeca().getId());
        validadorMaquina(entity.getMaquina().getId());
    }

    @Override
    public void beforeUpdate(RegistroProducaoEntity entity) {

    }

    @Override
    public void beforeDelete(RegistroProducao.Id id) {

    }
}
