/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for adicao
 */
@CommandDescription(name="adicaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="adicaoResponse")
public interface AdicaoResponse extends MessageHandler {

	void adicaoResponse(AdicaoOutput response);
	
	void adicaoResponseError(ErrorPayload error);

}
