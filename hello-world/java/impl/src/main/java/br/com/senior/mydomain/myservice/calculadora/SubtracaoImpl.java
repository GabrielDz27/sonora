package br.com.senior.mydomain.myservice.calculadora;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.Subtracao;
import br.com.senior.mydomain.myservice.SubtracaoInput;
import br.com.senior.mydomain.myservice.SubtracaoOutput;

import javax.inject.Inject;

@HandlerImpl
public class SubtracaoImpl implements Subtracao {

    @Inject
    private SubtracaoService subtracaoService;

    @Override
    public SubtracaoOutput subtracao(SubtracaoInput request) {

        SubtracaoOutput output = new SubtracaoOutput();
        output.resultado = subtracaoService.getSubtracao(request.numero1, request.numero2);
        return output;
    }
}
