package br.com.senior.mydomain.myservice.calculadora;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.Divisao;
import br.com.senior.mydomain.myservice.DivisaoInput;
import br.com.senior.mydomain.myservice.DivisaoOutput;

import javax.inject.Inject;

@HandlerImpl
public class DivisaoImpl implements Divisao {

    @Inject
    private DivisaoService divisaoService;

    @Override
    public DivisaoOutput divisao(DivisaoInput request) {

        DivisaoOutput output = new DivisaoOutput();
        output.resultado = divisaoService.getDivisao(request.numero1, request.numero2);
        return output;
    }
}
