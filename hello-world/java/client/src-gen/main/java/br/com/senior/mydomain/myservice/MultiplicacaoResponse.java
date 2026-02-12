/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for multiplicacao
 */
@CommandDescription(name="multiplicacaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="multiplicacaoResponse")
public interface MultiplicacaoResponse extends MessageHandler {

	void multiplicacaoResponse(MultiplicacaoOutput response);
	
	void multiplicacaoResponseError(ErrorPayload error);

}
