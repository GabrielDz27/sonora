package br.com.senior.mydomain.myservice.calculadora;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.Adicao;
import br.com.senior.mydomain.myservice.AdicaoInput;
import br.com.senior.mydomain.myservice.AdicaoOutput;

import javax.inject.Inject;

@HandlerImpl
public class AdicaoImpl implements Adicao {

    @Inject
    private AdicaoService adicaoService;

    @Override
    public AdicaoOutput adicao(AdicaoInput request) {

        AdicaoOutput output = new AdicaoOutput();
        output.resultado = adicaoService.getAdicao(request.numero1, request.numero2);

        return output;
    }
}
