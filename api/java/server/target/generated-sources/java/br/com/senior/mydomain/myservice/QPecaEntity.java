package br.com.senior.mydomain.myservice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPecaEntity is a Querydsl query type for PecaEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPecaEntity extends EntityPathBase<PecaEntity> {

    private static final long serialVersionUID = 859314470L;

    public static final QPecaEntity pecaEntity = new QPecaEntity("pecaEntity");

    public final br.com.senior.custom.QCustomEntity _super = new br.com.senior.custom.QCustomEntity(this);

    public final StringPath codigoDesenho = createString("codigoDesenho");

    //inherited
    public final MapPath<String, Object, SimplePath<Object>> customData = _super.customData;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath motivoPerda = createString("motivoPerda");

    public final StringPath nome = createString("nome");

    public final EnumPath<StatusPeca> status = createEnum("status", StatusPeca.class);

    public final NumberPath<Long> tempoEstimadoMinutos = createNumber("tempoEstimadoMinutos", Long.class);

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QPecaEntity(String variable) {
        super(PecaEntity.class, forVariable(variable));
    }

    public QPecaEntity(Path<? extends PecaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPecaEntity(PathMetadata metadata) {
        super(PecaEntity.class, metadata);
    }

}

