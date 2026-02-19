/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createBulkRegistroProducao
 */
@CommandDescription(name="createBulkRegistroProducaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createBulkRegistroProducaoResponse")
public interface CreateBulkRegistroProducaoResponse extends MessageHandler {

	void createBulkRegistroProducaoResponse(CreateBulkRegistroProducaoOutput response);
	
	void createBulkRegistroProducaoResponseError(ErrorPayload error);

}
