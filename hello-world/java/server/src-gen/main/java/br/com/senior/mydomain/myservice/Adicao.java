/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="adicao", kind=CommandKind.Action, requestPrimitive="adicao", responsePrimitive="adicaoResponse")
public interface Adicao extends MessageHandler {
    
    public AdicaoOutput adicao(AdicaoInput request);
    
}
