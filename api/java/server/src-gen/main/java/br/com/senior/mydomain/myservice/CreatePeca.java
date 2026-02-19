/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'create' request primitive for the Peca entity.
 */
@CommandDescription(name="createPeca", kind=CommandKind.Create, requestPrimitive="createPeca", responsePrimitive="createPecaResponse")
public interface CreatePeca extends MessageHandler {
    
    public Peca createPeca(Peca toCreate);
    
}
