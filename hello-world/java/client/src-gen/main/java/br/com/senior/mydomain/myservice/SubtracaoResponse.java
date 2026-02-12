/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for subtracao
 */
@CommandDescription(name="subtracaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="subtracaoResponse")
public interface SubtracaoResponse extends MessageHandler {

	void subtracaoResponse(SubtracaoOutput response);
	
	void subtracaoResponseError(ErrorPayload error);

}
