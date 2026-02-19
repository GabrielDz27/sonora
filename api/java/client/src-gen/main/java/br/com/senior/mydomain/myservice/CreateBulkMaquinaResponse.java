/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createBulkMaquina
 */
@CommandDescription(name="createBulkMaquinaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createBulkMaquinaResponse")
public interface CreateBulkMaquinaResponse extends MessageHandler {

	void createBulkMaquinaResponse(CreateBulkMaquinaOutput response);
	
	void createBulkMaquinaResponseError(ErrorPayload error);

}
