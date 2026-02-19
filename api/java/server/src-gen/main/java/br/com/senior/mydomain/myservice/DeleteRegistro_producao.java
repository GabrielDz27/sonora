/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'delete' request primitive for the Registro_producao entity.
 */
@CommandDescription(name="deleteRegistro_producao", kind=CommandKind.Delete, requestPrimitive="deleteRegistro_producao", responsePrimitive="deleteRegistro_producaoResponse")
public interface DeleteRegistro_producao extends MessageHandler {
    
    public void deleteRegistro_producao(Registro_producao.Id id);
    
}
