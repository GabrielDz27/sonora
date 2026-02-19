/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'delete' request primitive for the Maquina entity.
 */
@CommandDescription(name="deleteMaquina", kind=CommandKind.Delete, requestPrimitive="deleteMaquina", responsePrimitive="deleteMaquinaResponse")
public interface DeleteMaquina extends MessageHandler {
    
    public void deleteMaquina(Maquina.Id id);
    
}
