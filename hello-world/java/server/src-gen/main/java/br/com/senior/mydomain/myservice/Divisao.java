/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="divisao", kind=CommandKind.Action, requestPrimitive="divisao", responsePrimitive="divisaoResponse")
public interface Divisao extends MessageHandler {
    
    public DivisaoOutput divisao(DivisaoInput request);
    
}
