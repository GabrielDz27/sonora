/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createBulkPeca
 */
@CommandDescription(name="createBulkPecaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createBulkPecaResponse")
public interface CreateBulkPecaResponse extends MessageHandler {

	void createBulkPecaResponse(CreateBulkPecaOutput response);
	
	void createBulkPecaResponseError(ErrorPayload error);

}
