/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="findByNome", kind=CommandKind.Query, requestPrimitive="findByNome", responsePrimitive="findByNomeResponse")
public interface FindByNome extends MessageHandler {
    
    public FindByNomeOutput findByNome(FindByNomeInput request);
    
}
