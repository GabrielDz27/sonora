/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.*;

@CommandDescription(name="importPeca", kind=CommandKind.Action, requestPrimitive="importPeca", responsePrimitive="importPecaResponse")
public interface ImportPeca extends MessageHandler {
    
    public ImportPecaOutput importPeca(ImportPecaInput request);
    
}
