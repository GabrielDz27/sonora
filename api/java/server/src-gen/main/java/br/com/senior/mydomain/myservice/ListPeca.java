/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'list' request primitive for the Peca entity.
 */
@CommandDescription(name="listPeca", kind=CommandKind.List, requestPrimitive="listPeca", responsePrimitive="listPecaResponse")
public interface ListPeca extends MessageHandler {
    
    public Peca.PagedResults listPeca(Peca.PageRequest pageRequest);
    
}
