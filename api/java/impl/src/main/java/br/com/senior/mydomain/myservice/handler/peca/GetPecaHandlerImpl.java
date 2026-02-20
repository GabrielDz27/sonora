package br.com.senior.mydomain.myservice.handler.peca;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.services.peca.PecaService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@HandlerImpl
public class GetPecaHandlerImpl implements GetPeca {

    @Inject
    private PecaService pecaService;

    @Override
    public GetPecaOutput getPeca(GetPecaInput request) {
        final List<PecaEntity> pecasEntity = pecaService.getPecasPendentes(request.status);

        final List<Peca> pecas = pecasEntity.stream().map(
                pecaEntity ->  new Peca(
                        String.valueOf(pecaEntity.getId()),
                        pecaEntity.getNome(),
                        pecaEntity.getCodigoDesenho(),
                        pecaEntity.getTempoEstimadoMinutos(),
                        pecaEntity.getStatus(),
                        pecaEntity.getValor(),
                        pecaEntity.getMotivoPerda(),
                        null
                )
        ).collect(Collectors.toList());

        return new GetPecaOutput(pecas);
    }
}
