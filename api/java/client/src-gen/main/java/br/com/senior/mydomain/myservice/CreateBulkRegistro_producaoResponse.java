/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createBulkRegistro_producao
 */
@CommandDescription(name="createBulkRegistro_producaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createBulkRegistro_producaoResponse")
public interface CreateBulkRegistro_producaoResponse extends MessageHandler {

	void createBulkRegistro_producaoResponse(CreateBulkRegistro_producaoOutput response);
	
	void createBulkRegistro_producaoResponseError(ErrorPayload error);

}
