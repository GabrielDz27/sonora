/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for updatePeca
 */
@CommandDescription(name="updatePecaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updatePecaResponse")
public interface UpdatePecaResponse extends MessageHandler {

	void updatePecaResponse(Peca response);
	
	void updatePecaResponseError(ErrorPayload error);

}
