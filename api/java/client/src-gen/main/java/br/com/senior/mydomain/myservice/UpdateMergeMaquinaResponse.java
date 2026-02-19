/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for updateMergeMaquina
 */
@CommandDescription(name="updateMergeMaquinaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateMergeMaquinaResponse")
public interface UpdateMergeMaquinaResponse extends MessageHandler {

	void updateMergeMaquinaResponse(Maquina response);
	
	void updateMergeMaquinaResponseError(ErrorPayload error);

}
