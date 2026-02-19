/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'retrieve' request primitive for the Registro_producao entity.
 */
@CommandDescription(name="retrieveRegistro_producao", kind=CommandKind.Retrieve, requestPrimitive="retrieveRegistro_producao", responsePrimitive="retrieveRegistro_producaoResponse")
public interface RetrieveRegistro_producao extends MessageHandler {
    
    public Registro_producao retrieveRegistro_producao(Registro_producao.GetRequest id);
    
}
