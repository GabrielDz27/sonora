/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;	

import br.com.senior.messaging.ErrorPayload;
import br.com.senior.messaging.model.CommandDescription;
import br.com.senior.messaging.model.CommandKind;
import br.com.senior.messaging.model.MessageHandler;

/**
 * Response method for exportRegistroProducao
 */
@CommandDescription(name="exportRegistroProducaoResponse", kind=CommandKind.ResponseCommand, requestPrimitive="exportRegistroProducaoResponse")
public interface ExportRegistroProducaoResponse extends MessageHandler {

	void exportRegistroProducaoResponse(ExportRegistroProducaoOutput response);
	
	void exportRegistroProducaoResponseError(ErrorPayload error);

}
