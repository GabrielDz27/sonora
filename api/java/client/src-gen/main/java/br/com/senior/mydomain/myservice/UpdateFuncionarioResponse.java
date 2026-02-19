/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for updateFuncionario
 */
@CommandDescription(name="updateFuncionarioResponse", kind=CommandKind.ResponseCommand, requestPrimitive="updateFuncionarioResponse")
public interface UpdateFuncionarioResponse extends MessageHandler {

	void updateFuncionarioResponse(Funcionario response);
	
	void updateFuncionarioResponseError(ErrorPayload error);

}
