/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for divisao
 */
@CommandDescription(name="divisaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="divisaoResponse")
public interface DivisaoResponse extends MessageHandler {

	void divisaoResponse(DivisaoOutput response);
	
	void divisaoResponseError(ErrorPayload error);

}
