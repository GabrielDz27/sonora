package br.com.senior.mydomain.myservice;

import br.com.senior.EventPublisher;
import br.com.senior.messaging.model.HandlerImpl;

import java.util.Random;

@HandlerImpl
public class ComprarIngressoImpl implements ComprarIngresso {

    @Override
    public ComprarIngressoOutput comprarIngresso(ComprarIngressoInput request) {
        String codigoIngresso = Integer.toString(new Random().nextInt(100));

        IngressoCompradoPayload payload = new IngressoCompradoPayload();
        payload.codigoIngresso = codigoIngresso;
        EventPublisher.publish(MyServiceConstants.Events.INGRESSO_COMPRADO, payload);

        ComprarIngressoOutput response = new ComprarIngressoOutput();
        response.codigoIngresso = codigoIngresso;
        return response;
    }
}
