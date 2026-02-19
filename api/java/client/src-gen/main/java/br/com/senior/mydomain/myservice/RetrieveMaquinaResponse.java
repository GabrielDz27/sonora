/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for retrieveMaquina
 */
@CommandDescription(name="retrieveMaquinaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="retrieveMaquinaResponse")
public interface RetrieveMaquinaResponse extends MessageHandler {

	void retrieveMaquinaResponse(Maquina response);
	
	void retrieveMaquinaResponseError(ErrorPayload error);

}
