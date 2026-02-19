/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for importRegistro_producao
 */
@CommandDescription(name="importRegistro_producaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="importRegistro_producaoResponse")
public interface ImportRegistro_producaoResponse extends MessageHandler {

	void importRegistro_producaoResponse(ImportRegistro_producaoOutput response);
	
	void importRegistro_producaoResponseError(ErrorPayload error);

}
