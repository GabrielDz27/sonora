/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for listMaquina
 */
@CommandDescription(name="listMaquinaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="listMaquinaResponse")
public interface ListMaquinaResponse extends MessageHandler {

	void listMaquinaResponse(Maquina.PagedResults response);
	
	void listMaquinaResponseError(ErrorPayload error);

}
