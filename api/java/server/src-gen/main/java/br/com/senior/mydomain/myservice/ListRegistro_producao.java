/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * The 'list' request primitive for the Registro_producao entity.
 */
@CommandDescription(name="listRegistro_producao", kind=CommandKind.List, requestPrimitive="listRegistro_producao", responsePrimitive="listRegistro_producaoResponse")
public interface ListRegistro_producao extends MessageHandler {
    
    public Registro_producao.PagedResults listRegistro_producao(Registro_producao.PageRequest pageRequest);
    
}
