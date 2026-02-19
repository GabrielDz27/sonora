/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for retrieveRegistroProducao
 */
@CommandDescription(name="retrieveRegistroProducaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="retrieveRegistroProducaoResponse")
public interface RetrieveRegistroProducaoResponse extends MessageHandler {

	void retrieveRegistroProducaoResponse(RegistroProducao response);
	
	void retrieveRegistroProducaoResponseError(ErrorPayload error);

}
