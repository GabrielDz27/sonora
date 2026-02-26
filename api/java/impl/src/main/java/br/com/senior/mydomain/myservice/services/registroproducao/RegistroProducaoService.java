package br.com.senior.mydomain.myservice.services.registroproducao;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import br.com.senior.mydomain.myservice.repositories.registroproducao.RegistroProducaoRepository;
import br.com.senior.mydomain.myservice.services.peca.PecaService;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistroProducaoService {

    @Inject
    private RegistroProducaoRepository registroProducaoRepository;

    @Inject
    private PecaRepository pecaRepository;

    @Inject
    private TranslationHubApi translationHubApi;

    public RetornoAtualizarStatus finalizar(String id) {
        registroProducaoRepository.updateStatusById(LocalDateTime.now(), UUID.fromString(id));

        RegistroProducaoEntity registroProducaoEntity = registroProducaoRepository.findById(UUID.fromString(id)).get();

        pecaRepository.updateStatusById(StatusPeca.FINALIZADO, registroProducaoEntity.getPeca().getId());

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

    public List<RecordRegistroProducao> listagemRegistroProducao() {
        return registroProducaoRepository.findAllCompleto();
    }
}
