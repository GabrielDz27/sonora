package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.HandlerImpl;

@HandlerImpl
public class PagamentoEstornadoImpl implements PagamentoEstornado {

    @Override
    public void pagamentoEstornado(PagamentoEstornadoPayload payload) {
        System.out.println("Pagamento estornado para o ingresso " + payload.codigoIngresso);
    }
}
