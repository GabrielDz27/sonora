/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for mudarStatusPeca
 */
@CommandDescription(name="mudarStatusPecaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="mudarStatusPecaResponse")
public interface MudarStatusPecaResponse extends MessageHandler {

	void mudarStatusPecaResponse(MudarStatusPecaOutput response);
	
	void mudarStatusPecaResponseError(ErrorPayload error);

}
