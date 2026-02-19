/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'list' request primitive for the RegistroProducao entity.
 */
@CommandDescription(name="listRegistroProducao", kind=CommandKind.List, requestPrimitive="listRegistroProducao", responsePrimitive="listRegistroProducaoResponse")
public interface ListRegistroProducao extends MessageHandler {
    
    public RegistroProducao.PagedResults listRegistroProducao(RegistroProducao.PageRequest pageRequest);
    
}
