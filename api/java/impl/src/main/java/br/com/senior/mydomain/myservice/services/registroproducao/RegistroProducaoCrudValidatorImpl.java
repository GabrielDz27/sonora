package br.com.senior.mydomain.myservice.services.registroproducao;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.RegistroProducao;
import br.com.senior.mydomain.myservice.RegistroProducaoCrudValidator;
import br.com.senior.mydomain.myservice.RegistroProducaoEntity;
import br.com.senior.mydomain.myservice.repositories.maquina.MaquinaRepository;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import br.com.senior.mydomain.myservice.repositories.registroproducao.RegistroProducaoRepository;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RegistroProducaoCrudValidatorImpl implements RegistroProducaoCrudValidator {

    @Inject
    private MaquinaRepository maquinaRepository;

    @Inject
    private PecaRepository pecaRepository;

    @Inject
    private RegistroProducaoRepository registroProducaoRepository;

    @Inject
    private TranslationHubApi translationHubApi;

    private void validadorPeca(UUID idPeca) {
        if (pecaRepository.isPecaStatusNotPendente(idPeca)) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getMessage("br.com.senior.my_domain.my_service.erroPecaJaUsada"));
        }
    }

    private void validadorMaquina(UUID idMaquina) {
        if (maquinaRepository.isMaquinaStatusNotAtiva(idMaquina)) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getMessage("br.com.senior.my_domain.my_service.maquinaNaoAtiva"));
        }

        if (registroProducaoRepository.isMaquinaUsada(LocalDateTime.now(), idMaquina)) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getMessage("br.com.senior.my_domain.my_service.maquinaJaUsada"));
        }
    }

    @Override
    public void beforeCreate(RegistroProducaoEntity entity) {
        validadorPeca(entity.getPeca().getId());
        validadorMaquina(entity.getMaquina().getId());
    }

    @Override
    public void beforeUpdate(RegistroProducaoEntity entity) {
        validadorPeca(entity.getPeca().getId());
        validadorMaquina(entity.getMaquina().getId());
    }

    @Override
    public void beforeDelete(RegistroProducao.Id id) {

    }
}
