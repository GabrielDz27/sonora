package br.com.senior.mydomain.myservice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMaquinaEntity is a Querydsl query type for MaquinaEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMaquinaEntity extends EntityPathBase<MaquinaEntity> {

    private static final long serialVersionUID = 1810564823L;

    public static final QMaquinaEntity maquinaEntity = new QMaquinaEntity("maquinaEntity");

    public final br.com.senior.custom.QCustomEntity _super = new br.com.senior.custom.QCustomEntity(this);

    //inherited
    public final MapPath<String, Object, SimplePath<Object>> customData = _super.customData;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath nome = createString("nome");

    public final EnumPath<StatusMaquina> status = createEnum("status", StatusMaquina.class);

    public QMaquinaEntity(String variable) {
        super(MaquinaEntity.class, forVariable(variable));
    }

    public QMaquinaEntity(Path<? extends MaquinaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaquinaEntity(PathMetadata metadata) {
        super(MaquinaEntity.class, metadata);
    }

}

