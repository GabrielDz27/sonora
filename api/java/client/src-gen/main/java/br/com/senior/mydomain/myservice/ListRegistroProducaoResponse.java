/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for listRegistroProducao
 */
@CommandDescription(name="listRegistroProducaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="listRegistroProducaoResponse")
public interface ListRegistroProducaoResponse extends MessageHandler {

	void listRegistroProducaoResponse(RegistroProducao.PagedResults response);
	
	void listRegistroProducaoResponseError(ErrorPayload error);

}
