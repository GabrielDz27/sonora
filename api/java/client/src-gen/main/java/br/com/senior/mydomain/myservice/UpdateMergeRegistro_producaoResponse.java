/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for updateMergeRegistro_producao
 */
@CommandDescription(name="updateMergeRegistro_producaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateMergeRegistro_producaoResponse")
public interface UpdateMergeRegistro_producaoResponse extends MessageHandler {

	void updateMergeRegistro_producaoResponse(Registro_producao response);
	
	void updateMergeRegistro_producaoResponseError(ErrorPayload error);

}
