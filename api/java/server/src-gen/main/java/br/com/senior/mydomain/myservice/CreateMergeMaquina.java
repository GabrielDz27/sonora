/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'createMerge' request primitive for the Maquina entity.
 */
@CommandDescription(name="createMergeMaquina", kind=CommandKind.CreateMerge, requestPrimitive="createMergeMaquina", responsePrimitive="createMergeMaquinaResponse")
public interface CreateMergeMaquina extends MessageHandler {
    
    public Maquina createMergeMaquina(Maquina toCreateMerge);
    
}
