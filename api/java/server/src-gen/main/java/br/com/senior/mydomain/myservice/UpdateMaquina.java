/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'update' request primitive for the Maquina entity.
 */
@CommandDescription(name="updateMaquina", kind=CommandKind.Update, requestPrimitive="updateMaquina", responsePrimitive="updateMaquinaResponse")
public interface UpdateMaquina extends MessageHandler {
    
    public Maquina updateMaquina(Maquina toUpdate);
    
}
