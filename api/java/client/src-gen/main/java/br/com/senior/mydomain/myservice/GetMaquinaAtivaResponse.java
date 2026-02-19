/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for getMaquinaAtiva
 */
@CommandDescription(name="getMaquinaAtivaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="getMaquinaAtivaResponse")
public interface GetMaquinaAtivaResponse extends MessageHandler {

	void getMaquinaAtivaResponse(GetMaquinaAtivaOutput response);
	
	void getMaquinaAtivaResponseError(ErrorPayload error);

}
