/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="retornaIdFuncionario", kind=CommandKind.Query, requestPrimitive="retornaIdFuncionario", responsePrimitive="retornaIdFuncionarioResponse")
public interface RetornaIdFuncionario extends MessageHandler {
    
    public RetornaIdFuncionarioOutput retornaIdFuncionario(RetornaIdFuncionarioInput request);
    
}
