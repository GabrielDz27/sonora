package br.com.senior.mydomain.myservice.convidado;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.Convidado;
import br.com.senior.mydomain.myservice.ConvidadoCrudValidator;
import br.com.senior.mydomain.myservice.ConvidadoEntity;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ConvidadoCrudValidatorImpl implements ConvidadoCrudValidator {


    private static void validadorCpf(String cpf) {
        final Pattern pattern = Pattern.compile("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cpf);

        boolean matchFound = matcher.find();

        if(matchFound) {
            System.out.println("Match found");
        } else {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, "formato correto");
        }
    }

    @Override
    public void beforeCreate(ConvidadoEntity entity) {
        if (entity.getNome().toLowerCase().startsWith("roberto")) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, "Roberto nao e permetido");
        }
        validadorCpf(entity.getCpf());

    }

    @Override
    public void beforeUpdate(ConvidadoEntity entity) {
        validadorCpf(entity.getCpf());
    }

    @Override
    public void beforeDelete(Convidado.Id id) {

    }
}
