/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'updateMerge' request primitive for the RegistroProducao entity.
 */
@CommandDescription(name="updateMergeRegistroProducao", kind=CommandKind.UpdateMerge, requestPrimitive="updateMergeRegistroProducao", responsePrimitive="updateMergeRegistroProducaoResponse")
public interface UpdateMergeRegistroProducao extends MessageHandler {
    
    public RegistroProducao updateMergeRegistroProducao(RegistroProducao toUpdateMerge);
    
}
