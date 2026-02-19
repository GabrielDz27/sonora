/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'update' request primitive for the Peca entity.
 */
@CommandDescription(name="updatePeca", kind=CommandKind.Update, requestPrimitive="updatePeca", responsePrimitive="updatePecaResponse")
public interface UpdatePeca extends MessageHandler {
    
    public Peca updatePeca(Peca toUpdate);
    
}
