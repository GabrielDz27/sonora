package br.com.senior.mydomain.myservice.handler.registroProducao;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.RecordRegistroProducao;
import br.com.senior.mydomain.myservice.RetornaRegistroProducao;
import br.com.senior.mydomain.myservice.RetornaRegistroProducaoOutput;
import br.com.senior.mydomain.myservice.services.registroproducao.RegistroProducaoService;

import javax.inject.Inject;

@HandlerImpl
public class RetornaRegistroProducaoImpl implements RetornaRegistroProducao {

    @Inject
    private RegistroProducaoService registroProducaoService;

    @Override
    public RetornaRegistroProducaoOutput retornaRegistroProducao() {
        RetornaRegistroProducaoOutput retornaRegistroProducao = new RetornaRegistroProducaoOutput();
        retornaRegistroProducao.retorno = registroProducaoService.listagemRegistroProducao();
        System.out.println(retornaRegistroProducao);
        return retornaRegistroProducao;
    }
}
