/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for retornaRegistroProducao
 */
@CommandDescription(name="retornaRegistroProducaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="retornaRegistroProducaoResponse")
public interface RetornaRegistroProducaoResponse extends MessageHandler {

	void retornaRegistroProducaoResponse(RetornaRegistroProducaoOutput response);
	
	void retornaRegistroProducaoResponseError(ErrorPayload error);

}
