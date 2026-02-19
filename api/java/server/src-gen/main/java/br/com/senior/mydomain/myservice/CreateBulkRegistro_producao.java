/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name = "createBulkRegistro_producao", kind = CommandKind.Create, requestPrimitive = "createBulkRegistro_producao", responsePrimitive="")
public interface CreateBulkRegistro_producao extends MessageHandler {
    public CreateBulkRegistro_producaoOutput createBulkRegistro_producao(CreateBulkRegistro_producaoInput toCreate);
}
