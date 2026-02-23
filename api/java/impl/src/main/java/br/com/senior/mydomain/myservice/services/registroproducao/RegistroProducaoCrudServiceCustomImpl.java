package br.com.senior.mydomain.myservice.services.registroproducao;

import br.com.senior.mydomain.myservice.RegistroProducaoCrudServiceImpl;
import br.com.senior.mydomain.myservice.RegistroProducaoEntity;
import br.com.senior.mydomain.myservice.StatusPeca;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
@Primary
public class RegistroProducaoCrudServiceCustomImpl extends RegistroProducaoCrudServiceImpl {

    @Inject
    private PecaRepository pecaRepository;

    @Override
    public RegistroProducaoEntity create(RegistroProducaoEntity entity) {
        pecaRepository.updateStatusById(StatusPeca.PROCESSO, entity.getPeca().getId());
        return super.create(entity);
    }

    @Override
    public RegistroProducaoEntity updateRegistroProducao(RegistroProducaoEntity entity) {
        return super.updateRegistroProducao(entity);
    }
}
