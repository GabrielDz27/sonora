/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

/**
 * Cadastrar um novo eventos (ex: SeniorTec, Casamento, etc)
 */
@CommandDescription(name="cadastrarEvento", kind=CommandKind.Action, requestPrimitive="cadastrarEvento", responsePrimitive="cadastrarEventoResponse")
public interface CadastrarEvento extends MessageHandler {
    
    public CadastrarEventoOutput cadastrarEvento(CadastrarEventoInput request);
    
}
