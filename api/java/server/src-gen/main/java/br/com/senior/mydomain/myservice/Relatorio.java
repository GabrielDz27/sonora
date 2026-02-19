/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="relatorio", kind=CommandKind.Query, requestPrimitive="relatorio", responsePrimitive="relatorioResponse")
public interface Relatorio extends MessageHandler {
    
    public RelatorioOutput relatorio(RelatorioInput request);
    
}
