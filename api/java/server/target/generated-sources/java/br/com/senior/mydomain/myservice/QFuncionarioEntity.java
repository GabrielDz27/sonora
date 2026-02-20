package br.com.senior.mydomain.myservice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFuncionarioEntity is a Querydsl query type for FuncionarioEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFuncionarioEntity extends EntityPathBase<FuncionarioEntity> {

    private static final long serialVersionUID = 1894543694L;

    public static final QFuncionarioEntity funcionarioEntity = new QFuncionarioEntity("funcionarioEntity");

    public final br.com.senior.custom.QCustomEntity _super = new br.com.senior.custom.QCustomEntity(this);

    public final BooleanPath ativo = createBoolean("ativo");

    public final StringPath cargo = createString("cargo");

    //inherited
    public final MapPath<String, Object, SimplePath<Object>> customData = _super.customData;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath matricula = createString("matricula");

    public final StringPath nome = createString("nome");

    public final EnumPath<TurnoFuncionario> turno = createEnum("turno", TurnoFuncionario.class);

    public QFuncionarioEntity(String variable) {
        super(FuncionarioEntity.class, forVariable(variable));
    }

    public QFuncionarioEntity(Path<? extends FuncionarioEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFuncionarioEntity(PathMetadata metadata) {
        super(FuncionarioEntity.class, metadata);
    }

}

