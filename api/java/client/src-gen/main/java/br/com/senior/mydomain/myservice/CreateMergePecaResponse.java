/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createMergePeca
 */
@CommandDescription(name="createMergePecaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createMergePecaResponse")
public interface CreateMergePecaResponse extends MessageHandler {

	void createMergePecaResponse(Peca response);
	
	void createMergePecaResponseError(ErrorPayload error);

}
