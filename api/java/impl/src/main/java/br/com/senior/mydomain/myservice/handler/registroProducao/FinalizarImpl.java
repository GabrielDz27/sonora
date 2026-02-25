package br.com.senior.mydomain.myservice.handler.registroProducao;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.services.registroproducao.RegistroProducaoService;

import javax.inject.Inject;

@HandlerImpl
public class FinalizarImpl implements Finalizar {

    @Inject
    private RegistroProducaoService registroProducaoService;

    @Override
    public FinalizarOutput finalizar(FinalizarInput request) {

        RetornoAtualizarStatus retornoAtualizarStatus = registroProducaoService.finalizar(request.id);
        return new FinalizarOutput(retornoAtualizarStatus);
    }
}
