/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'update' request primitive for the Registro_producao entity.
 */
@CommandDescription(name="updateRegistro_producao", kind=CommandKind.Update, requestPrimitive="updateRegistro_producao", responsePrimitive="updateRegistro_producaoResponse")
public interface UpdateRegistro_producao extends MessageHandler {
    
    public Registro_producao updateRegistro_producao(Registro_producao toUpdate);
    
}
