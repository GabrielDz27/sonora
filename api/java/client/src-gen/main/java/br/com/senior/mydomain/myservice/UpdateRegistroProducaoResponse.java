/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for updateRegistroProducao
 */
@CommandDescription(name="updateRegistroProducaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateRegistroProducaoResponse")
public interface UpdateRegistroProducaoResponse extends MessageHandler {

	void updateRegistroProducaoResponse(RegistroProducao response);
	
	void updateRegistroProducaoResponseError(ErrorPayload error);

}
