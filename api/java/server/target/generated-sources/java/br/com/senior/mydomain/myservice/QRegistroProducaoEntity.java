package br.com.senior.mydomain.myservice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRegistroProducaoEntity is a Querydsl query type for RegistroProducaoEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRegistroProducaoEntity extends EntityPathBase<RegistroProducaoEntity> {

    private static final long serialVersionUID = -198367687L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRegistroProducaoEntity registroProducaoEntity = new QRegistroProducaoEntity("registroProducaoEntity");

    public final br.com.senior.custom.QCustomEntity _super = new br.com.senior.custom.QCustomEntity(this);

    //inherited
    public final MapPath<String, Object, SimplePath<Object>> customData = _super.customData;

    public final DateTimePath<java.time.Instant> dataFinal = createDateTime("dataFinal", java.time.Instant.class);

    public final DateTimePath<java.time.Instant> dataInicio = createDateTime("dataInicio", java.time.Instant.class);

    public final QFuncionarioEntity funcionario;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final QMaquinaEntity maquina;

    public final QPecaEntity peca;

    public QRegistroProducaoEntity(String variable) {
        this(RegistroProducaoEntity.class, forVariable(variable), INITS);
    }

    public QRegistroProducaoEntity(Path<? extends RegistroProducaoEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRegistroProducaoEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRegistroProducaoEntity(PathMetadata metadata, PathInits inits) {
        this(RegistroProducaoEntity.class, metadata, inits);
    }

    public QRegistroProducaoEntity(Class<? extends RegistroProducaoEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.funcionario = inits.isInitialized("funcionario") ? new QFuncionarioEntity(forProperty("funcionario")) : null;
        this.maquina = inits.isInitialized("maquina") ? new QMaquinaEntity(forProperty("maquina")) : null;
        this.peca = inits.isInitialized("peca") ? new QPecaEntity(forProperty("peca")) : null;
    }

}

