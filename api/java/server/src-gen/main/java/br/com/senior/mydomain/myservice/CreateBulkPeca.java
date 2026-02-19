/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name = "createBulkPeca", kind = CommandKind.Create, requestPrimitive = "createBulkPeca", responsePrimitive="")
public interface CreateBulkPeca extends MessageHandler {
    public CreateBulkPecaOutput createBulkPeca(CreateBulkPecaInput toCreate);
}
