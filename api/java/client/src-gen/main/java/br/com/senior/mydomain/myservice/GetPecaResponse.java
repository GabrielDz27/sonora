/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for getPeca
 */
@CommandDescription(name="getPecaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="getPecaResponse")
public interface GetPecaResponse extends MessageHandler {

	void getPecaResponse(GetPecaOutput response);
	
	void getPecaResponseError(ErrorPayload error);

}
