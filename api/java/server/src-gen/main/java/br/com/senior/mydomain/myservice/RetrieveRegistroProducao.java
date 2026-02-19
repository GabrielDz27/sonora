/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'retrieve' request primitive for the RegistroProducao entity.
 */
@CommandDescription(name="retrieveRegistroProducao", kind=CommandKind.Retrieve, requestPrimitive="retrieveRegistroProducao", responsePrimitive="retrieveRegistroProducaoResponse")
public interface RetrieveRegistroProducao extends MessageHandler {
    
    public RegistroProducao retrieveRegistroProducao(RegistroProducao.GetRequest id);
    
}
