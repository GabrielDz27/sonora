/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="findNomeById", kind=CommandKind.Query, requestPrimitive="findNomeById", responsePrimitive="findNomeByIdResponse")
public interface FindNomeById extends MessageHandler {
    
    public FindNomeByIdOutput findNomeById(FindNomeByIdInput request);
    
}
