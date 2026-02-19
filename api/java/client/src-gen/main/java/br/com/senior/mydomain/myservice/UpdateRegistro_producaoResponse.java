/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for updateRegistro_producao
 */
@CommandDescription(name="updateRegistro_producaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateRegistro_producaoResponse")
public interface UpdateRegistro_producaoResponse extends MessageHandler {

	void updateRegistro_producaoResponse(Registro_producao response);
	
	void updateRegistro_producaoResponseError(ErrorPayload error);

}
