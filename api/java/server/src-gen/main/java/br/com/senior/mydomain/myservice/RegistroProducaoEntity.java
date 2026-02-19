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
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

import br.com.senior.custom.CustomEntity;
import br.com.senior.custom.odata.entity.ODataEntity;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import org.springframework.data.domain.Persistable;

@Entity(name="my_domain.my_service.RegistroProducaoEntity")
@ODataEntity(id = "registroProducao")
@Table(name="registro_producao")
public class RegistroProducaoEntity extends CustomEntity implements Persistable<java.util.UUID> {
	
	public static final String SECURITY_RESOURCE = "res://senior.com.br/my_domain/my_service/entities/registroProducao";

	/**
	 * Identificador único UUID
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;
	
	/**
	 * Relacionamento com a peça processada
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "peca")
	private PecaEntity peca;
	
	/**
	 * Relacionamento com o operador responsável
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funcionario")
	private FuncionarioEntity funcionario;
	
	/**
	 * Relacionamento com a máquina utilizada
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maquina")
	private MaquinaEntity maquina;
	
	/**
	 * Data e hora do 'Play' na produção
	 */
	@Column(name = "data_inicio")
	private java.time.Instant dataInicio;
	
	/**
	 * Data e hora do 'Stop' ou descarte
	 */
	@Column(name = "data_final")
	private java.time.Instant dataFinal;
	
	@Transient
	private boolean _newEntity;
	
	@Override
	public java.util.UUID getPk() {
		return this.id;
	}
	
	@Override
	public String getServiceEntityName() {
		return "registroProducao";
	}
	
	public java.util.UUID getId() {
		return id;
	}
	
	public PecaEntity getPeca() {
		return peca;
	}
	
	public FuncionarioEntity getFuncionario() {
		return funcionario;
	}
	
	public MaquinaEntity getMaquina() {
		return maquina;
	}
	
	public java.time.Instant getDataInicio() {
		return dataInicio;
	}
	
	public java.time.Instant getDataFinal() {
		return dataFinal;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setPeca(PecaEntity peca) {
		this.peca = peca;
	}
	
	public void setFuncionario(FuncionarioEntity funcionario) {
		this.funcionario = funcionario;
	}
	
	public void setMaquina(MaquinaEntity maquina) {
		this.maquina = maquina;
	}
	
	public void setDataInicio(java.time.Instant dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public void setDataFinal(java.time.Instant dataFinal) {
		this.dataFinal = dataFinal;
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
	    if (!(obj instanceof RegistroProducaoEntity)) {
	        return false;
	    }
	    RegistroProducaoEntity other = (RegistroProducaoEntity) obj;
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
		RegistroProducaoEntityStringSerializer.INSTANCE.serialize(this, sb, appended);
	}
	
}
