/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for exportMaquina
 */
@CommandDescription(name="exportMaquinaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="exportMaquinaResponse")
public interface ExportMaquinaResponse extends MessageHandler {

	void exportMaquinaResponse(ExportMaquinaOutput response);
	
	void exportMaquinaResponseError(ErrorPayload error);

}
