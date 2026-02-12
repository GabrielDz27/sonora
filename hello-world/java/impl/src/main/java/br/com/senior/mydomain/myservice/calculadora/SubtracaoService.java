package br.com.senior.mydomain.myservice.calculadora;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.SubtracaoInput;
import br.com.senior.mydomain.myservice.SubtracaoOutput;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SubtracaoService {

    @Inject
    private TranslationHubApi translationHubApi;

    public String getSubtracao(double numero1, double numero2) throws ServiceException {

        try {
            Double resultado = numero1 - numero2;
            return translationHubApi.getFormattedMessage(
                    "br.com.senior.my_domain.my_service.operacao_mais_resultado",
                    "Subtracao",
                    resultado
            );
        } catch (Exception e) {
            throw new ServiceException(ErrorCategory.INTERNAL_ERROR, e);
        }
    }

}
