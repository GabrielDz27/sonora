/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createMergeRegistroProducao
 */
@CommandDescription(name="createMergeRegistroProducaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createMergeRegistroProducaoResponse")
public interface CreateMergeRegistroProducaoResponse extends MessageHandler {

	void createMergeRegistroProducaoResponse(RegistroProducao response);
	
	void createMergeRegistroProducaoResponseError(ErrorPayload error);

}
