/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createMaquina
 */
@CommandDescription(name="createMaquinaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createMaquinaResponse")
public interface CreateMaquinaResponse extends MessageHandler {

	void createMaquinaResponse(Maquina response);
	
	void createMaquinaResponseError(ErrorPayload error);

}
