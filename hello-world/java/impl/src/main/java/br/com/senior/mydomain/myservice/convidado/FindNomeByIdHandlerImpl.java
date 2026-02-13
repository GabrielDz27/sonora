package br.com.senior.mydomain.myservice.convidado;

import br.com.senior.mydomain.myservice.FindNomeById;
import br.com.senior.mydomain.myservice.FindNomeByIdInput;
import br.com.senior.mydomain.myservice.FindNomeByIdOutput;

import javax.inject.Inject;

public class FindNomeByIdHandlerImpl implements FindNomeById {

    @Inject
    private ConvidadoService convidadoService;

    @Override
    public FindNomeByIdOutput findNomeById(FindNomeByIdInput request) {
        return new FindNomeByIdOutput(convidadoService.findNomeById(request.id));
    }
}
