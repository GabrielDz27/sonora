package br.com.senior.mydomain.myservice.handler.peca;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.MudarStatusPeca;
import br.com.senior.mydomain.myservice.MudarStatusPecaInput;
import br.com.senior.mydomain.myservice.MudarStatusPecaOutput;
import br.com.senior.mydomain.myservice.RetornoAtualizarStatus;
import br.com.senior.mydomain.myservice.services.peca.PecaService;

import javax.inject.Inject;

@HandlerImpl
public class MudarStatusPecaImpl implements MudarStatusPeca {

    @Inject
    private PecaService pecaService;

    @Override
    public MudarStatusPecaOutput mudarStatusPeca(MudarStatusPecaInput request) {

        RetornoAtualizarStatus retornoAtualizarStatus = pecaService.atualizarStatus(request.id, request.status);
        return new MudarStatusPecaOutput(retornoAtualizarStatus);
    }
}