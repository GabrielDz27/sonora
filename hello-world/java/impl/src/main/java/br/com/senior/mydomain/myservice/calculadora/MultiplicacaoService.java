package br.com.senior.mydomain.myservice.calculadora;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MultiplicacaoService {

    @Inject
    private TranslationHubApi translationHubApi;

    public String getMultiplicacao(double a, double b) {

        try {
            double resultado = a * b;

            return translationHubApi.getFormattedMessage(
                    "br.com.senior.my_domain.my_service.operacao_mais_resultado",
                    "multiplicao",
                    resultado);
        } catch (Exception e) {
            throw new ServiceException(ErrorCategory.INTERNAL_ERROR, e);
        }
    }
}
