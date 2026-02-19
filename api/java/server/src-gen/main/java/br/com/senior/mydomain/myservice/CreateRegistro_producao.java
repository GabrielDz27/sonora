/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'create' request primitive for the Registro_producao entity.
 */
@CommandDescription(name="createRegistro_producao", kind=CommandKind.Create, requestPrimitive="createRegistro_producao", responsePrimitive="createRegistro_producaoResponse")
public interface CreateRegistro_producao extends MessageHandler {
    
    public Registro_producao createRegistro_producao(Registro_producao toCreate);
    
}
