/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for importMaquina
 */
@CommandDescription(name="importMaquinaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="importMaquinaResponse")
public interface ImportMaquinaResponse extends MessageHandler {

	void importMaquinaResponse(ImportMaquinaOutput response);
	
	void importMaquinaResponseError(ErrorPayload error);

}
