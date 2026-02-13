/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for findIngressoByNomeConvidado
 */
@CommandDescription(name="findIngressoByNomeConvidadoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="findIngressoByNomeConvidadoResponse")
public interface FindIngressoByNomeConvidadoResponse extends MessageHandler {

	void findIngressoByNomeConvidadoResponse(FindIngressoByNomeConvidadoOutput response);
	
	void findIngressoByNomeConvidadoResponseError(ErrorPayload error);

}
