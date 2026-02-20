package br.com.senior.mydomain.myservice.handler.maquina;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.GetMaquinaAtiva;
import br.com.senior.mydomain.myservice.GetMaquinaAtivaOutput;
import br.com.senior.mydomain.myservice.Maquina;
import br.com.senior.mydomain.myservice.MaquinaEntity;
import br.com.senior.mydomain.myservice.services.maquina.MaquinaService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@HandlerImpl
public class GetMaquinaAtivaHandlerImpl implements GetMaquinaAtiva {

    @Inject
    private MaquinaService maquinaService;

    @Override
    public GetMaquinaAtivaOutput getMaquinaAtiva() {
        List<MaquinaEntity> maquinaEntities = maquinaService.getMaquinasStatusAtivas();
        final List<Maquina> maquinas = maquinaEntities.stream().map(
                m -> new Maquina(
                        String.valueOf(m.getId()),
                        m.getNome(),
                        m.getStatus(),
                        null
                )
        ).collect(Collectors.toList());

        return new GetMaquinaAtivaOutput(maquinas);
    }
}
