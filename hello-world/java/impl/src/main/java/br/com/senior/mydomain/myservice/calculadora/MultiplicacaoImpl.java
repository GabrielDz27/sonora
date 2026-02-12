package br.com.senior.mydomain.myservice.calculadora;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.*;

import javax.inject.Inject;

@HandlerImpl
public class MultiplicacaoImpl implements Multiplicacao {
    @Inject
    private MultiplicacaoService multiplicacaoService;

    @Override
    public MultiplicacaoOutput multiplicacao(MultiplicacaoInput request) {

        MultiplicacaoOutput ret = new MultiplicacaoOutput();
        ret.resultado = multiplicacaoService.getMultiplicacao(request.numero1, request.numero2);
        return ret;
    }
}
