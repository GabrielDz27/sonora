/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for importRegistroProducao
 */
@CommandDescription(name="importRegistroProducaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="importRegistroProducaoResponse")
public interface ImportRegistroProducaoResponse extends MessageHandler {

	void importRegistroProducaoResponse(ImportRegistroProducaoOutput response);
	
	void importRegistroProducaoResponseError(ErrorPayload error);

}
