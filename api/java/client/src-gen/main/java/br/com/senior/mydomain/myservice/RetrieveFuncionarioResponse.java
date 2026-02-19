/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for retrieveFuncionario
 */
@CommandDescription(name="retrieveFuncionarioResponse", kind=CommandKind.ResponseCommand, requestPrimitive="retrieveFuncionarioResponse")
public interface RetrieveFuncionarioResponse extends MessageHandler {

	void retrieveFuncionarioResponse(Funcionario response);
	
	void retrieveFuncionarioResponseError(ErrorPayload error);

}
