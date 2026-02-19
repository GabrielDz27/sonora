/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'delete' request primitive for the Peca entity.
 */
@CommandDescription(name="deletePeca", kind=CommandKind.Delete, requestPrimitive="deletePeca", responsePrimitive="deletePecaResponse")
public interface DeletePeca extends MessageHandler {
    
    public void deletePeca(Peca.Id id);
    
}
