/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'update' request primitive for the RegistroProducao entity.
 */
@CommandDescription(name="updateRegistroProducao", kind=CommandKind.Update, requestPrimitive="updateRegistroProducao", responsePrimitive="updateRegistroProducaoResponse")
public interface UpdateRegistroProducao extends MessageHandler {
    
    public RegistroProducao updateRegistroProducao(RegistroProducao toUpdate);
    
}
