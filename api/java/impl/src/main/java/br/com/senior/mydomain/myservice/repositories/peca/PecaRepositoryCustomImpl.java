package br.com.senior.mydomain.myservice.repositories.peca;

import br.com.senior.mydomain.myservice.PecaEntity;
import br.com.senior.mydomain.myservice.QPecaEntity;
import br.com.senior.mydomain.myservice.StatusPeca;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PecaRepositoryCustomImpl implements PecaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PecaEntity> getPecasPendentes() {
        QPecaEntity qPecaEntity = QPecaEntity.pecaEntity;

        return new JPAQuery<>(em)
                .select(qPecaEntity)
                .from(qPecaEntity)
                .where(qPecaEntity.status.eq(StatusPeca.PENDENTE))
                .fetch();
    }
}
