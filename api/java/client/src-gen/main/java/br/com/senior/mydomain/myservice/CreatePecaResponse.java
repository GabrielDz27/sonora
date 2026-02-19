/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createPeca
 */
@CommandDescription(name="createPecaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createPecaResponse")
public interface CreatePecaResponse extends MessageHandler {

	void createPecaResponse(Peca response);
	
	void createPecaResponseError(ErrorPayload error);

}
