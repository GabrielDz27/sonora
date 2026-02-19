/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createRegistro_producao
 */
@CommandDescription(name="createRegistro_producaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createRegistro_producaoResponse")
public interface CreateRegistro_producaoResponse extends MessageHandler {

	void createRegistro_producaoResponse(Registro_producao response);
	
	void createRegistro_producaoResponseError(ErrorPayload error);

}
