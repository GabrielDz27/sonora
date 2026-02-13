package br.com.senior.mydomain.myservice.ingresso;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.GetIdsByNomeConvidado;
import br.com.senior.mydomain.myservice.GetIdsByNomeConvidadoInput;
import br.com.senior.mydomain.myservice.GetIdsByNomeConvidadoOutput;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@HandlerImpl
public class GetIdsByNomeConvidadoHandlerImpl implements GetIdsByNomeConvidado {

    @Inject
    private IngressoService ingressoService;

    @Override
    public GetIdsByNomeConvidadoOutput getIdsByNomeConvidado(GetIdsByNomeConvidadoInput request) {
        final List<UUID> idsUUIDconvidados = ingressoService.getIdsByConvidadoNome(request.nomeConvidado);
        final List<String> idsConvidados = idsUUIDconvidados.stream().map( li -> li.toString()).collect(Collectors.toList());
        return new GetIdsByNomeConvidadoOutput(idsConvidados);
    }
}
