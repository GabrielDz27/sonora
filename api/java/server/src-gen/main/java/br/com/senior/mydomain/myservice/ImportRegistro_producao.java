/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="importRegistro_producao", kind=CommandKind.Action, requestPrimitive="importRegistro_producao", responsePrimitive="importRegistro_producaoResponse")
public interface ImportRegistro_producao extends MessageHandler {
    
    public ImportRegistro_producaoOutput importRegistro_producao(ImportRegistro_producaoInput request);
    
}
