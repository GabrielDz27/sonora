package br.com.senior.mydomain.myservice.services.registroproducao;

import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Primary
public class RegistroProducaoCrudServiceCustomImpl extends RegistroProducaoCrudServiceImpl {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private PecaRepository pecaRepository;

    @Override
    @Transactional
    public RegistroProducaoEntity createRegistroProducao(RegistroProducaoEntity entity) {
//
//        System.out.println(
//                "TIPOS -> maquina: " + (entity.getMaquina() == null ? null : entity.getMaquina().getClass().getName())
//        );
//        System.out.println(
//                "ID(s)  -> maquinaId: " + (entity.getMaquina() == null ? null : entity.getMaquina().getId())
//        );
//
//        pecaRepository.updateStatusById(StatusPeca.PROCESSO, entity.getPeca().getId());
//        System.out.println("RegistroProducaoCrudServiceCustomImpl createRegistroProducao"+entity);
//
        return super.create(entity);
    }
}
