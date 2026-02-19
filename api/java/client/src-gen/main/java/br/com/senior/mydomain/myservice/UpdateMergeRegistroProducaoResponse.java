/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for updateMergeRegistroProducao
 */
@CommandDescription(name="updateMergeRegistroProducaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateMergeRegistroProducaoResponse")
public interface UpdateMergeRegistroProducaoResponse extends MessageHandler {

	void updateMergeRegistroProducaoResponse(RegistroProducao response);
	
	void updateMergeRegistroProducaoResponseError(ErrorPayload error);

}
