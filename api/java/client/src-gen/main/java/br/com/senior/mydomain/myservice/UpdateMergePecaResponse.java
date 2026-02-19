/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for updateMergePeca
 */
@CommandDescription(name="updateMergePecaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateMergePecaResponse")
public interface UpdateMergePecaResponse extends MessageHandler {

	void updateMergePecaResponse(Peca response);
	
	void updateMergePecaResponseError(ErrorPayload error);

}
