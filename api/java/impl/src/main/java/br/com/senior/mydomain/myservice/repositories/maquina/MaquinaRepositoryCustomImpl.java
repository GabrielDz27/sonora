package br.com.senior.mydomain.myservice.repositories.maquina;

import br.com.senior.mydomain.myservice.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public List<MaquinaTrabalhando> maquinaTrabalhada(LocalDateTime inicio, LocalDateTime fim, List<String> maquinas) {
        QRegistroProducaoEntity r = QRegistroProducaoEntity.registroProducaoEntity;
        QMaquinaEntity m = QMaquinaEntity.maquinaEntity;

        BooleanBuilder where = new BooleanBuilder();

        // filtro período
        if (inicio != null && fim != null) {
            Instant ini = inicio.atZone(ZoneId.systemDefault()).toInstant();
            Instant end = fim.atZone(ZoneId.systemDefault()).toInstant();
            where.and(r.dataInicio.between(ini, end));
        }

        // somente registros finalizados
        where.and(r.dataFinal.isNotNull());

        // filtro máquinas
        if (maquinas != null && !maquinas.isEmpty()) {
            List<UUID> uuids = maquinas.stream()
                    .map(UUID::fromString)
                    .collect(Collectors.toList());

            where.and(m.id.in(uuids));
        }

        List<Tuple> rows =
                new JPAQuery<Tuple>(em)
                        .select(m.id, m.nome, r.dataInicio, r.dataFinal)
                        .from(r)
                        .join(r.maquina, m)
                        .where(where)
                        .fetch();

        // agrupar horas por máquina
        Map<UUID, Long> horasPorMaquina = new HashMap<>();
        Map<UUID, String> nomeMaquina = new HashMap<>();

        for (Tuple t : rows) {

            UUID maqId = t.get(m.id);
            String nome = t.get(m.nome);
            Instant ini = t.get(r.dataInicio);
            Instant fimReg = t.get(r.dataFinal);

            long horas = Duration.between(ini, fimReg).toHours();

            horasPorMaquina.merge(maqId, horas, Long::sum);
            nomeMaquina.putIfAbsent(maqId, nome);
        }

        List<MaquinaTrabalhando> resultado = new ArrayList<>();

        for (UUID id : horasPorMaquina.keySet()) {

            Maquina maqDto = new Maquina();
            maqDto.id = id.toString();
            maqDto.nome = nomeMaquina.get(id);

            resultado.add(
                    new MaquinaTrabalhando(
                            maqDto,
                            horasPorMaquina.get(id)
                    )
            );
        }

        return resultado;
    }
}
