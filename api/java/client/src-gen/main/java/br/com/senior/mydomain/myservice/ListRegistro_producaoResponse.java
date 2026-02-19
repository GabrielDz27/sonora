/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for listRegistro_producao
 */
@CommandDescription(name="listRegistro_producaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="listRegistro_producaoResponse")
public interface ListRegistro_producaoResponse extends MessageHandler {

	void listRegistro_producaoResponse(Registro_producao.PagedResults response);
	
	void listRegistro_producaoResponseError(ErrorPayload error);

}
