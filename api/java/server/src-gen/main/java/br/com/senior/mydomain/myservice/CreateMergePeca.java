/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'createMerge' request primitive for the Peca entity.
 */
@CommandDescription(name="createMergePeca", kind=CommandKind.CreateMerge, requestPrimitive="createMergePeca", responsePrimitive="createMergePecaResponse")
public interface CreateMergePeca extends MessageHandler {
    
    public Peca createMergePeca(Peca toCreateMerge);
    
}
