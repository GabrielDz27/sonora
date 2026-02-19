/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'createMerge' request primitive for the RegistroProducao entity.
 */
@CommandDescription(name="createMergeRegistroProducao", kind=CommandKind.CreateMerge, requestPrimitive="createMergeRegistroProducao", responsePrimitive="createMergeRegistroProducaoResponse")
public interface CreateMergeRegistroProducao extends MessageHandler {
    
    public RegistroProducao createMergeRegistroProducao(RegistroProducao toCreateMerge);
    
}
