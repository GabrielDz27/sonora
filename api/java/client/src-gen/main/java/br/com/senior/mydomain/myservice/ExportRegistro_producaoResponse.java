/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for exportRegistro_producao
 */
@CommandDescription(name="exportRegistro_producaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="exportRegistro_producaoResponse")
public interface ExportRegistro_producaoResponse extends MessageHandler {

	void exportRegistro_producaoResponse(ExportRegistro_producaoOutput response);
	
	void exportRegistro_producaoResponseError(ErrorPayload error);

}
