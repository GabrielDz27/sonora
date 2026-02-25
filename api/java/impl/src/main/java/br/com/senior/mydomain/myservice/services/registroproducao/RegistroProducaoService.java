package br.com.senior.mydomain.myservice.services.registroproducao;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.PecaEntity;
import br.com.senior.mydomain.myservice.RegistroProducaoEntity;
import br.com.senior.mydomain.myservice.RetornoAtualizarStatus;
import br.com.senior.mydomain.myservice.repositories.registroproducao.RegistroProducaoRepository;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistroProducaoService {

    @Inject
    private RegistroProducaoRepository registroProducaoRepository;

    @Inject
    private TranslationHubApi translationHubApi;

    public RetornoAtualizarStatus finalizar(String id) {
        registroProducaoRepository.updateStatusById(LocalDateTime.now(), UUID.fromString(id));

        final Optional<RegistroProducaoEntity> convidadoOpt = registroProducaoRepository.findById(UUID.fromString(id));
        if (convidadoOpt.isPresent()) {
            return new RetornoAtualizarStatus(
                    translationHubApi.getMessage("br.com.senior.my_domain.my_service.mensagemRetornoSucesso"),
                    String.valueOf(convidadoOpt.get().getId()),
                    false
            );
        } else {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getMessage("br.com.senior.my_domain.my_service.mensagemRetornoIdInvalido"));
        }
    }
}
