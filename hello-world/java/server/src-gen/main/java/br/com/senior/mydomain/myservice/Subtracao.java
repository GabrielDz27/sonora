/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="subtracao", kind=CommandKind.Action, requestPrimitive="subtracao", responsePrimitive="subtracaoResponse")
public interface Subtracao extends MessageHandler {
    
    public SubtracaoOutput subtracao(SubtracaoInput request);
    
}
