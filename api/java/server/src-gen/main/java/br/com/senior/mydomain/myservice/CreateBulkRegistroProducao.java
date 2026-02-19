/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name = "createBulkRegistroProducao", kind = CommandKind.Create, requestPrimitive = "createBulkRegistroProducao", responsePrimitive="")
public interface CreateBulkRegistroProducao extends MessageHandler {
    public CreateBulkRegistroProducaoOutput createBulkRegistroProducao(CreateBulkRegistroProducaoInput toCreate);
}
