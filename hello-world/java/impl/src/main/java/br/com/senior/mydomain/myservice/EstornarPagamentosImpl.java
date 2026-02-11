package br.com.senior.mydomain.myservice;

import br.com.senior.EventPublisher;
import br.com.senior.messaging.model.HandlerImpl;

@HandlerImpl
public class EstornarPagamentosImpl implements EstornarPagamentos{

    @Override
    public void estornarPagamentos(EstornarPagamentosInput payload) {

        payload.codigoIngresso.forEach(codigoIngresso -> {
            final PagamentoEstornadoPayload pay = new PagamentoEstornadoPayload();
            pay.codigoIngresso = codigoIngresso;
            EventPublisher.publish(MyServiceConstants.Events.INGRESSO_COMPRADO, payload);
        });

    }
}
