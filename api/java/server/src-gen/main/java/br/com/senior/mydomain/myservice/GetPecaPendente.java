/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * Trazendo todas pecas conforme o filtro
 */
@CommandDescription(name="getPecaPendente", kind=CommandKind.Query, requestPrimitive="getPecaPendente", responsePrimitive="getPecaPendenteResponse")
public interface GetPecaPendente extends MessageHandler {
    
    public GetPecaPendenteOutput getPecaPendente();
    
}
