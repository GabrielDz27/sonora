/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="exportPeca", kind=CommandKind.Query, requestPrimitive="exportPeca", responsePrimitive="exportPecaResponse")
public interface ExportPeca extends MessageHandler {
    
    public ExportPecaOutput exportPeca(ExportPecaInput request);
    
}
