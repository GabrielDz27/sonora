/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@SubscriptionDescription(domain="my_domain", service="my_service", event="importRegistro_producaoEvent")
public interface ImportRegistro_producaoEvent extends MessageHandler {
    public void importRegistro_producaoEvent(ImportRegistro_producaoEventPayload payload);
    
}
