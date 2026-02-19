/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'create' request primitive for the Maquina entity.
 */
@CommandDescription(name="createMaquina", kind=CommandKind.Create, requestPrimitive="createMaquina", responsePrimitive="createMaquinaResponse")
public interface CreateMaquina extends MessageHandler {
    
    public Maquina createMaquina(Maquina toCreate);
    
}
