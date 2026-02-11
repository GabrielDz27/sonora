package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.HandlerImpl;

@HandlerImpl
public class IngressoCompradoImpl implements IngressoComprado {

    @Override
    public void ingressoComprado(IngressoCompradoPayload payload) {
        System.out.println("IngressoCompradoImpl");
    }
}
