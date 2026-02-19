/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'create' request primitive for the RegistroProducao entity.
 */
@CommandDescription(name="createRegistroProducao", kind=CommandKind.Create, requestPrimitive="createRegistroProducao", responsePrimitive="createRegistroProducaoResponse")
public interface CreateRegistroProducao extends MessageHandler {
    
    public RegistroProducao createRegistroProducao(RegistroProducao toCreate);
    
}
