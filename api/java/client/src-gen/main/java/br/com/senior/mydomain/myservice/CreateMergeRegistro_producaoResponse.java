/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for createMergeRegistro_producao
 */
@CommandDescription(name="createMergeRegistro_producaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="createMergeRegistro_producaoResponse")
public interface CreateMergeRegistro_producaoResponse extends MessageHandler {

	void createMergeRegistro_producaoResponse(Registro_producao response);
	
	void createMergeRegistro_producaoResponseError(ErrorPayload error);

}
