/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for retornaIdFuncionario
 */
@CommandDescription(name="retornaIdFuncionarioResponse", kind=CommandKind.ResponseCommand, requestPrimitive="retornaIdFuncionarioResponse")
public interface RetornaIdFuncionarioResponse extends MessageHandler {

	void retornaIdFuncionarioResponse(RetornaIdFuncionarioOutput response);
	
	void retornaIdFuncionarioResponseError(ErrorPayload error);

}
