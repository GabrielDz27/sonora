/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'updateMerge' request primitive for the Registro_producao entity.
 */
@CommandDescription(name="updateMergeRegistro_producao", kind=CommandKind.UpdateMerge, requestPrimitive="updateMergeRegistro_producao", responsePrimitive="updateMergeRegistro_producaoResponse")
public interface UpdateMergeRegistro_producao extends MessageHandler {
    
    public Registro_producao updateMergeRegistro_producao(Registro_producao toUpdateMerge);
    
}
