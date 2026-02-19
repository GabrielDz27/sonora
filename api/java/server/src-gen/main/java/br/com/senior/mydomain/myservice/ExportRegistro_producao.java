/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="exportRegistro_producao", kind=CommandKind.Query, requestPrimitive="exportRegistro_producao", responsePrimitive="exportRegistro_producaoResponse")
public interface ExportRegistro_producao extends MessageHandler {
    
    public ExportRegistro_producaoOutput exportRegistro_producao(ExportRegistro_producaoInput request);
    
}
