/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'createMerge' request primitive for the Registro_producao entity.
 */
@CommandDescription(name="createMergeRegistro_producao", kind=CommandKind.CreateMerge, requestPrimitive="createMergeRegistro_producao", responsePrimitive="createMergeRegistro_producaoResponse")
public interface CreateMergeRegistro_producao extends MessageHandler {
    
    public Registro_producao createMergeRegistro_producao(Registro_producao toCreateMerge);
    
}
