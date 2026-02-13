package br.com.senior.mydomain.myservice.convidado;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.*;

import javax.inject.Inject;

@HandlerImpl
public class UpdateConvidadoNomeByIdHandlerImpl implements UpdateConvidadoNomeById {

    @Inject
    private ConvidadoService convidadoService;

    @Inject
    private ConvidadoConverter convidadoConverter;

    @Override
    public UpdateConvidadoNomeByIdOutput updateConvidadoNomeById(UpdateConvidadoNomeByIdInput request) {
        final ConvidadoEntity convidado = convidadoService.updateNomeById(request.nome, request.id);

        return convidadoConverter.toUpdateConvidadoNomeById(convidado);
    }
}
