/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for retrieveRegistro_producao
 */
@CommandDescription(name="retrieveRegistro_producaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="retrieveRegistro_producaoResponse")
public interface RetrieveRegistro_producaoResponse extends MessageHandler {

	void retrieveRegistro_producaoResponse(Registro_producao response);
	
	void retrieveRegistro_producaoResponseError(ErrorPayload error);

}
