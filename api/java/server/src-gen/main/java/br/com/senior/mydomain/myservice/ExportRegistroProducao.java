/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="exportRegistroProducao", kind=CommandKind.Query, requestPrimitive="exportRegistroProducao", responsePrimitive="exportRegistroProducaoResponse")
public interface ExportRegistroProducao extends MessageHandler {
    
    public ExportRegistroProducaoOutput exportRegistroProducao(ExportRegistroProducaoInput request);
    
}
