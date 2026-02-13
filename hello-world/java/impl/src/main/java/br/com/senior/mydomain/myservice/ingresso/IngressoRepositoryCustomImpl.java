package br.com.senior.mydomain.myservice.ingresso;

import br.com.senior.mydomain.myservice.IngressoEntity;
import br.com.senior.mydomain.myservice.QConvidadoEntity;
import br.com.senior.mydomain.myservice.QIngressoEntity;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

public class IngressoRepositoryCustomImpl implements IngressoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UUID> getIdsByConvidadoNome(String nome) {
        QConvidadoEntity convidadoEntity = QConvidadoEntity.convidadoEntity;
        QIngressoEntity ingressoEntity = QIngressoEntity.ingressoEntity;

        return new JPAQuery<>(entityManager)
                .select(ingressoEntity.id)
                .from(ingressoEntity)
                .join(convidadoEntity).on(convidadoEntity.eq(ingressoEntity.convidado))
                .where(convidadoEntity.nome.containsIgnoreCase(nome))
                .fetch();
    }
}
