package br.com.senior.mydomain.myservice.repositories.peca;

import br.com.senior.mydomain.myservice.PecaEntity;
import br.com.senior.mydomain.myservice.QPecaEntity;
import br.com.senior.mydomain.myservice.QRegistroProducaoEntity;
import br.com.senior.mydomain.myservice.StatusPeca;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class PecaRepositoryCustomImpl implements PecaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PecaEntity> getPecasPendentes(StatusPeca status) {
        QPecaEntity qPecaEntity = QPecaEntity.pecaEntity;

        return new JPAQuery<>(em)
                .select(qPecaEntity)
                .from(qPecaEntity)
                .where(qPecaEntity.status.eq(status))
                .fetch();
    }

    @Override
    public Long countPecaMorta(LocalDateTime inicio, LocalDateTime fim, List<String> desenhos) {
        QPecaEntity p = QPecaEntity.pecaEntity;
        QRegistroProducaoEntity r = QRegistroProducaoEntity.registroProducaoEntity;

        BooleanBuilder where = new BooleanBuilder();

        where.and(p.status.eq(StatusPeca.MORTA));

        if (inicio != null && fim != null) {
            where.and(r.dataInicio.between(inicio.atZone(ZoneId.systemDefault()).toInstant(),
                    fim.atZone(ZoneId.systemDefault()).toInstant()));
        }

        if (desenhos != null && !desenhos.isEmpty()) {
            where.and(p.codigoDesenho.in(desenhos));
        }

        return new JPAQuery<Long>(em)
                .select(p.id.countDistinct())
                .from(r)
                .join(r.peca, p)
                .where(where)
                .fetchOne();
    }
}
