/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * Trazendo todas pecas conforme o filtro
 */
@CommandDescription(name="getPeca", kind=CommandKind.Query, requestPrimitive="getPeca", responsePrimitive="getPecaResponse")
public interface GetPeca extends MessageHandler {
    
    public GetPecaOutput getPeca(GetPecaInput request);
    
}
