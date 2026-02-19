/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for exportPeca
 */
@CommandDescription(name="exportPecaResponse", kind=CommandKind.ResponseCommand, requestPrimitive="exportPecaResponse")
public interface ExportPecaResponse extends MessageHandler {

	void exportPecaResponse(ExportPecaOutput response);
	
	void exportPecaResponseError(ErrorPayload error);

}
