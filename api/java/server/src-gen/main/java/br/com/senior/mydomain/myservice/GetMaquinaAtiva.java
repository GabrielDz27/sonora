/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * Diretamente ja trazendo as maquinas ativas
 */
@CommandDescription(name="getMaquinaAtiva", kind=CommandKind.Query, requestPrimitive="getMaquinaAtiva", responsePrimitive="getMaquinaAtivaResponse")
public interface GetMaquinaAtiva extends MessageHandler {
    
    public GetMaquinaAtivaOutput getMaquinaAtiva();
    
}
