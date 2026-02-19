/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="mudarStatusPeca", kind=CommandKind.Action, requestPrimitive="mudarStatusPeca", responsePrimitive="mudarStatusPecaResponse")
public interface MudarStatusPeca extends MessageHandler {
    
    public MudarStatusPecaOutput mudarStatusPeca(MudarStatusPecaInput request);
    
}
