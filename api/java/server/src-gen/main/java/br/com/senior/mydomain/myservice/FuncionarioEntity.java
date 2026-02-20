/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

import br.com.senior.custom.CustomEntity;
import br.com.senior.custom.odata.entity.ODataEntity;
import javax.persistence.Transient;
import org.springframework.data.domain.Persistable;

@Entity(name="my_domain.my_service.FuncionarioEntity")
@ODataEntity(id = "funcionario")
@Table(name="funcionario")
public class FuncionarioEntity extends CustomEntity implements Persistable<java.util.UUID> {
	
	public static final String SECURITY_RESOURCE = "res://senior.com.br/my_domain/my_service/entities/funcionario";

	/**
	 * Identificador único UUID
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;
	
	/**
	 * Nome completo do colaborador
	 */
	@Column(name = "nome")
	private String nome;
	
	/**
	 * Registro único na empresa
	 */
	@Column(name = "matricula", length = 20)
	private String matricula;
	
	/**
	 * Função técnica na metalurgia
	 */
	@Column(name = "cargo")
	private String cargo;
	
	/**
	 * Turno: PRIMEIRO, SEGUNDO, TERCEIRO e DIURNO
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "turno")
	private TurnoFuncionario turno;
	
	/**
	 * Ativo, se funcionario foi deseligado na empresa ou foi reativado
	 */
	@Column(name = "ativo")
	private Boolean ativo;
	
	@Transient
	private boolean _newEntity;
	
	@Override
	public java.util.UUID getPk() {
		return this.id;
	}
	
	@Override
	public String getServiceEntityName() {
		return "funcionario";
	}
	
	public java.util.UUID getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public TurnoFuncionario getTurno() {
		return turno;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setTurno(TurnoFuncionario turno) {
		this.turno = turno;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public boolean isNew() {
		return _newEntity;
	}
	
	public void defineAsNewEntity() {
		this._newEntity = true;
	}
	
	@Override
	public int hashCode() {
	    int ret = 1;
	    if (id != null) {
	        ret = 31 * ret + id.hashCode();
	    }
	    return ret;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (!(obj instanceof FuncionarioEntity)) {
	        return false;
	    }
	    FuncionarioEntity other = (FuncionarioEntity) obj;
	    if (id == null) {
	        return false;
	    }
	    if ((id != null) && !id.equals(other.id)) {
	        return false;
	    }
	    return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(sb, new ArrayList<>());
		return sb.toString();
	}
	
	void toString(StringBuilder sb, List<Object> appended) {
		FuncionarioEntityStringSerializer.INSTANCE.serialize(this, sb, appended);
	}
	
}
