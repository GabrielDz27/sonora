package br.com.senior.mydomain.myservice.handler;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.Relatorio;
import br.com.senior.mydomain.myservice.RelatorioInput;
import br.com.senior.mydomain.myservice.RelatorioOutput;
import br.com.senior.mydomain.myservice.repositories.funcionario.FuncionarioRepository;
import br.com.senior.mydomain.myservice.repositories.maquina.MaquinaRepository;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import br.com.senior.mydomain.myservice.services.relatorio.RelatorioService;

import javax.inject.Inject;

@HandlerImpl
public class RelatorioImpl implements Relatorio {

    @Inject
    private RelatorioService relatorioService;

    @Override
    public RelatorioOutput relatorio(RelatorioInput request) {

        RelatorioOutput output = new RelatorioOutput();
        output.retorno = relatorioService.retornaDados(request);
        return output;
    }
}
