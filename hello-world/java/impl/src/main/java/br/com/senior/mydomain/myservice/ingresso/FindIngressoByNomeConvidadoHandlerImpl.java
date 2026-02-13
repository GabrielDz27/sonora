package br.com.senior.mydomain.myservice.ingresso;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@HandlerImpl
public class FindIngressoByNomeConvidadoHandlerImpl implements FindIngressoByNomeConvidado {

    @Inject
    private IngressoService ingressoService;

    @Override
    public FindIngressoByNomeConvidadoOutput findIngressoByNomeConvidado(FindIngressoByNomeConvidadoInput request) {
        final List<IngressoEntity> ingressos = ingressoService.findByNomeConvidado(request.nomeConvidado);


        final List<Ingresso> ingressoDto = ingressos.stream().map(ingresso -> new Ingresso(
                    ingresso.getId().toString(),
                    ingresso.getDataHora(),
                    null,
                    ingresso.getQuantidadeAcompanhantes(),
                    null,
                    null
                )
        ).collect(Collectors.toList());

        return new FindIngressoByNomeConvidadoOutput(ingressoDto);
    }
}
