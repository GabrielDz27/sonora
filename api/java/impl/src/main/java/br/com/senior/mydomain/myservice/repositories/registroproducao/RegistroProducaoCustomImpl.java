package br.com.senior.mydomain.myservice.repositories.registroproducao;

import br.com.senior.mydomain.myservice.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RegistroProducaoCustomImpl implements RegistroProducaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<RecordRegistroProducao> findAllCompleto() {

        QRegistroProducaoEntity registro = QRegistroProducaoEntity.registroProducaoEntity;
        QPecaEntity peca = QPecaEntity.pecaEntity;
        QMaquinaEntity maquina = QMaquinaEntity.maquinaEntity;
        QFuncionarioEntity funcionario = QFuncionarioEntity.funcionarioEntity;

        List<Tuple> rows = new JPAQuery<>(em)
                .select(registro, peca, funcionario, maquina)
                .from(registro)
                .join(registro.peca, peca)
                .join(registro.funcionario, funcionario)
                .join(registro.maquina, maquina)
                .fetch();

        List<RecordRegistroProducao> lista = new ArrayList<>();

        for (Tuple row : rows) {

            RegistroProducaoEntity re = row.get(registro);
            PecaEntity pe = row.get(peca);
            FuncionarioEntity fe = row.get(funcionario);
            MaquinaEntity me = row.get(maquina);

            if (re == null) continue;

            Peca pecaDto = null;
            if (pe != null) {
                pecaDto = new Peca(
                        pe.getId() != null ? pe.getId().toString() : null,
                        pe.getNome(),
                        pe.getCodigoDesenho(),
                        pe.getTempoEstimadoMinutos(),
                        pe.getStatus(),
                        pe.getValor(),
                        pe.getMotivoPerda(),
                        null
                );
            }

            Funcionario funcionarioDto = null;
            if (fe != null) {
                funcionarioDto = new Funcionario(
                        fe.getId() != null ? fe.getId().toString() : null,
                        fe.getNome(),
                        fe.getMatricula(),
                        fe.getCargo(),
                        fe.getTurno(),
                        fe.getAtivo(),
                        fe.getUsername(),
                        null
                );
            }

            Maquina maquinaDto = null;
            if (me != null) {
                maquinaDto = new Maquina(
                        me.getId() != null ? me.getId().toString() : null,
                        me.getNome(),
                        me.getStatus(),
                        null
                );
            }

            RecordRegistroProducao dto = new RecordRegistroProducao(
                    re.getId() != null ? re.getId().toString() : null,
                    pecaDto,
                    funcionarioDto,
                    maquinaDto,
                    re.getDataInicio(),
                    re.getDataFinal()
            );

            lista.add(dto);
        }

        return lista;
    }

    @Override
    public List<PecaFuncionario> pecaPorFuncionario(
            LocalDateTime inicio,
            LocalDateTime fim,
            List<String> funcionarios,
            String turno) {

        QRegistroProducaoEntity r = QRegistroProducaoEntity.registroProducaoEntity;
        QFuncionarioEntity f = QFuncionarioEntity.funcionarioEntity;
        QPecaEntity p = QPecaEntity.pecaEntity;

        BooleanBuilder where = new BooleanBuilder();

        if (inicio != null && fim != null) {
            where.and(
                    r.dataInicio.between(
                            inicio.atZone(ZoneId.systemDefault()).toInstant(),
                            fim.atZone(ZoneId.systemDefault()).toInstant()
                    )
            );
        }

        if (funcionarios != null && !funcionarios.isEmpty()) {
            List<UUID> ids = funcionarios.stream()
                    .map(UUID::fromString)
                    .collect(Collectors.toList());

            where.and(f.id.in(ids));
        }

        if (turno != null && !turno.isBlank()) {
            where.and(f.turno.stringValue().equalsIgnoreCase(turno));
        }

        List<Tuple> rows = new JPAQuery<>(em)
                .select(r, f, p)
                .from(r)
                .join(r.funcionario, f)
                .join(r.peca, p)
                .where(where)
                .fetch();

        List<PecaFuncionario> lista = new ArrayList<>();

        for (Tuple row : rows) {

            RegistroProducaoEntity re = row.get(r);
            FuncionarioEntity fe = row.get(f);
            PecaEntity pe = row.get(p);

            if (re == null) continue;

            Peca pecaDto = null;
            if (pe != null) {
                pecaDto = new Peca(
                        pe.getId() != null ? pe.getId().toString() : null,
                        pe.getNome(),
                        pe.getCodigoDesenho(),
                        pe.getTempoEstimadoMinutos(),
                        pe.getStatus(),
                        pe.getValor(),
                        pe.getMotivoPerda(),
                        null
                );
            }

            Funcionario funcionarioDto = null;
            if (fe != null) {
                funcionarioDto = new Funcionario(
                        fe.getId() != null ? fe.getId().toString() : null,
                        fe.getNome(),
                        fe.getMatricula(),
                        fe.getCargo(),
                        fe.getTurno(),
                        fe.getAtivo(),
                        fe.getUsername(),
                        null
                );
            }

            lista.add(new PecaFuncionario(pecaDto, funcionarioDto));
        }

        return lista;
    }
}


