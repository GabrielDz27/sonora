/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="finalizar", kind=CommandKind.Action, requestPrimitive="finalizar", responsePrimitive="finalizarResponse")
public interface Finalizar extends MessageHandler {
    
    public FinalizarOutput finalizar(FinalizarInput request);
    
}
