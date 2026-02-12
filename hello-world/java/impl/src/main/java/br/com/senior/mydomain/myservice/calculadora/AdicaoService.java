package br.com.senior.mydomain.myservice.calculadora;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class AdicaoService {

    @Inject
    private TranslationHubApi translationHubApi;

    public String getAdicao (double numero1, double numero2) {

        try {
            double resultado = numero1 + numero2;
            return translationHubApi.getFormattedMessage(
                    "br.com.senior.my_domain.my_service.operacao_mais_resultado",
                    "Adicao",
                    resultado
            );
        } catch (Exception e) {
            throw new ServiceException(ErrorCategory.INTERNAL_ERROR, e);
        }
    }
}
