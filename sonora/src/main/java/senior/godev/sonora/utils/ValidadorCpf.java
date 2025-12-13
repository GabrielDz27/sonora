package senior.godev.sonora.utils;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidadorCpf {
    private final CPFValidator validator;

    public ValidadorCpf() {
        this.validator = new CPFValidator(false);
    }

    public boolean validarCpf(String cpf) {
        if (cpf == null) {
            return false;
        }

        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        try {
            validator.assertValid(cpfLimpo);
            return true;
        } catch (InvalidStateException e) {
            return false;
        }
    }

}
