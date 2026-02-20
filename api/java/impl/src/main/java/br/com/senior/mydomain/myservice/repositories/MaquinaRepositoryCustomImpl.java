package br.com.senior.mydomain.myservice.repositories;

import br.com.senior.mydomain.myservice.MaquinaEntity;
import br.com.senior.mydomain.myservice.QMaquinaEntity;
import br.com.senior.mydomain.myservice.StatusMaquina;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MaquinaRepositoryCustomImpl implements MaquinaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MaquinaEntity> getMaquinasStatusAtivas() {
        QMaquinaEntity qMaquinaEntity = QMaquinaEntity.maquinaEntity;

        return new JPAQuery<>(em)
                .select(qMaquinaEntity).from(qMaquinaEntity).where(qMaquinaEntity.status.eq(StatusMaquina.ATIVO))
                .fetch();
    }
}
