package br.com.senior.mydomain.myservice.convidado;

import br.com.senior.mydomain.myservice.ConvidadoEntity;
import br.com.senior.mydomain.myservice.QConvidadoEntity;
import br.com.senior.mydomain.myservice.QEventoEntity;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

public class ConvidadoRepositoryCustomImpl implements ConvidadoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public String findNomeByIdCustom(UUID id) {

        return em.createQuery("select c.nome from my_domain.my_service.ConvidadoEntity c where c.id = :id", String.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<ConvidadoEntity> getAll() {
        QConvidadoEntity qConvidado = QConvidadoEntity.convidadoEntity;

        return new JPAQuery<>(em)
                .select(qConvidado).from(qConvidado).fetch();
    }
}
