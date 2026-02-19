/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'updateMerge' request primitive for the Maquina entity.
 */
@CommandDescription(name="updateMergeMaquina", kind=CommandKind.UpdateMerge, requestPrimitive="updateMergeMaquina", responsePrimitive="updateMergeMaquinaResponse")
public interface UpdateMergeMaquina extends MessageHandler {
    
    public Maquina updateMergeMaquina(Maquina toUpdateMerge);
    
}
