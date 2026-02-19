/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createMergeMaquina
 */
@CommandDescription(name="createMergeMaquinaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createMergeMaquinaResponse")
public interface CreateMergeMaquinaResponse extends MessageHandler {

	void createMergeMaquinaResponse(Maquina response);
	
	void createMergeMaquinaResponseError(ErrorPayload error);

}
