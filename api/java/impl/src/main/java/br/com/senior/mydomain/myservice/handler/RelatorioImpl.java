package br.com.senior.mydomain.myservice.handler;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.Relatorio;
import br.com.senior.mydomain.myservice.RelatorioInput;
import br.com.senior.mydomain.myservice.RelatorioOutput;

@HandlerImpl
public class RelatorioImpl implements Relatorio {

    @Override
    public RelatorioOutput relatorio(RelatorioInput request) {

        RelatorioOutput output = new RelatorioOutput();
        return output;
    }
}
