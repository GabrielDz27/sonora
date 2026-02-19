/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'list' request primitive for the Maquina entity.
 */
@CommandDescription(name="listMaquina", kind=CommandKind.List, requestPrimitive="listMaquina", responsePrimitive="listMaquinaResponse")
public interface ListMaquina extends MessageHandler {
    
    public Maquina.PagedResults listMaquina(Maquina.PageRequest pageRequest);
    
}
