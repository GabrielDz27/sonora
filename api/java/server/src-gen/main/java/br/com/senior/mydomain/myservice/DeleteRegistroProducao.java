/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'delete' request primitive for the RegistroProducao entity.
 */
@CommandDescription(name="deleteRegistroProducao", kind=CommandKind.Delete, requestPrimitive="deleteRegistroProducao", responsePrimitive="deleteRegistroProducaoResponse")
public interface DeleteRegistroProducao extends MessageHandler {
    
    public void deleteRegistroProducao(RegistroProducao.Id id);
    
}
