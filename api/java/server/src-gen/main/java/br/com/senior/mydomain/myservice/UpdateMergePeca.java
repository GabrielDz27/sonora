/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'updateMerge' request primitive for the Peca entity.
 */
@CommandDescription(name="updateMergePeca", kind=CommandKind.UpdateMerge, requestPrimitive="updateMergePeca", responsePrimitive="updateMergePecaResponse")
public interface UpdateMergePeca extends MessageHandler {
    
    public Peca updateMergePeca(Peca toUpdateMerge);
    
}
