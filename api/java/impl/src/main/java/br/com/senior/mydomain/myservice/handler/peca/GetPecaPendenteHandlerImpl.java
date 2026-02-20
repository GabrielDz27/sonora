package br.com.senior.mydomain.myservice.handler.peca;

import br.com.senior.mydomain.myservice.GetPecaPendente;
import br.com.senior.mydomain.myservice.GetPecaPendenteOutput;
import br.com.senior.mydomain.myservice.Peca;
import br.com.senior.mydomain.myservice.PecaEntity;
import br.com.senior.mydomain.myservice.services.peca.PecaService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class GetPecaPendenteHandlerImpl implements GetPecaPendente {

    @Inject
    private PecaService pecaService;

    @Override
    public GetPecaPendenteOutput getPecaPendente() {
        final List<PecaEntity> pecasEntity = pecaService.getPecasPendentes();

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

        return new GetPecaPendenteOutput(pecas);
    }
}
