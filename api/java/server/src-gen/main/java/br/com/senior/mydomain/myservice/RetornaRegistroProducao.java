/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="retornaRegistroProducao", kind=CommandKind.Query, requestPrimitive="retornaRegistroProducao", responsePrimitive="retornaRegistroProducaoResponse")
public interface RetornaRegistroProducao extends MessageHandler {
    
    public RetornaRegistroProducaoOutput retornaRegistroProducao();
    
}
