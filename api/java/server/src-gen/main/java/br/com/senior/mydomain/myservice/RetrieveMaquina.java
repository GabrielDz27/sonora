/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'retrieve' request primitive for the Maquina entity.
 */
@CommandDescription(name="retrieveMaquina", kind=CommandKind.Retrieve, requestPrimitive="retrieveMaquina", responsePrimitive="retrieveMaquinaResponse")
public interface RetrieveMaquina extends MessageHandler {
    
    public Maquina retrieveMaquina(Maquina.GetRequest id);
    
}
