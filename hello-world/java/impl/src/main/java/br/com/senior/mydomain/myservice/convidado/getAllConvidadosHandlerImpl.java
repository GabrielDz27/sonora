package br.com.senior.mydomain.myservice.convidado;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@HandlerImpl
public class getAllConvidadosHandlerImpl implements GetAllConvidados {

    @Inject
    private ConvidadoService convidadoService;

    @Override
    public GetAllConvidadosOutput getAllConvidados(GetAllConvidadosInput request) {
        final List<ConvidadoEntity> convidados = convidadoService.getAll();

        final List<String> ids = convidados.stream().map(c -> c.getId().toString()).collect(Collectors.toList());
        return new GetAllConvidadosOutput(ids);
    }
}
