package br.com.senior.mydomain.myservice.calculadora;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class DivisaoService {
    @Inject
    private TranslationHubApi translationHubApi;

    public String getDivisao(double numero1, double numero2) throws ServiceException {
        if (numero2 == 0){
            throw new ServiceException(ErrorCategory.BAD_REQUEST,"Divisor igual a 0");
        }

        try {
            Double resultado = numero1 - numero2;
            return translationHubApi.getFormattedMessage(
                    "br.com.senior.my_domain.my_service.operacao_mais_resultado",
                    "Divisao",
                    resultado
            );
        } catch (Exception e) {
            throw new ServiceException(ErrorCategory.INTERNAL_ERROR, e);
        }
    }
}
