/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for retrievePeca
 */
@CommandDescription(name="retrievePecaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="retrievePecaResponse")
public interface RetrievePecaResponse extends MessageHandler {

	void retrievePecaResponse(Peca response);
	
	void retrievePecaResponseError(ErrorPayload error);

}
