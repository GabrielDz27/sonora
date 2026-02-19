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

@Entity(name="my_domain.my_service.PecaEntity")
@ODataEntity(id = "peca")
@Table(name="peca")
public class PecaEntity extends CustomEntity implements Persistable<java.util.UUID> {
	
	public static final String SECURITY_RESOURCE = "res://senior.com.br/my_domain/my_service/entities/peca";

	/**
	 * Identificador único UUID
	 */
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", updatable = false)
	private java.util.UUID id;
	
	/**
	 * Nome descritivo do item
	 */
	@Column(name = "nome", length = 100)
	private String nome;
	
	/**
	 * Referência técnica do projeto
	 */
	@Column(name = "codigo_desenho", length = 50)
	private String codigoDesenho;
	
	/**
	 * Tempo previsto para fabricação
	 */
	@Column(name = "tempo_estimado_minutos")
	private Long tempoEstimadoMinutos;
	
	/**
	 * Estado atual: PENDENTE, PROCESSO, FINALIZADO, MORTA
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusPeca status;
	
	/**
	 * Valor da peça
	 */
	@Column(name = "valor")
	private java.math.BigDecimal valor;
	
	/**
	 * Motivo pela perda peça quando o status da peça é morta
	 */
	@Column(name = "motivo_perda")
	private String motivoPerda;
	
	@Transient
	private boolean _newEntity;
	
	@Override
	public java.util.UUID getPk() {
		return this.id;
	}
	
	@Override
	public String getServiceEntityName() {
		return "peca";
	}
	
	public java.util.UUID getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCodigoDesenho() {
		return codigoDesenho;
	}
	
	public Long getTempoEstimadoMinutos() {
		return tempoEstimadoMinutos;
	}
	
	public StatusPeca getStatus() {
		return status;
	}
	
	public java.math.BigDecimal getValor() {
		return valor;
	}
	
	public String getMotivoPerda() {
		return motivoPerda;
	}
	
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCodigoDesenho(String codigoDesenho) {
		this.codigoDesenho = codigoDesenho;
	}
	
	public void setTempoEstimadoMinutos(Long tempoEstimadoMinutos) {
		this.tempoEstimadoMinutos = tempoEstimadoMinutos;
	}
	
	public void setStatus(StatusPeca status) {
		this.status = status;
	}
	
	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}
	
	public void setMotivoPerda(String motivoPerda) {
		this.motivoPerda = motivoPerda;
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
	    if (!(obj instanceof PecaEntity)) {
	        return false;
	    }
	    PecaEntity other = (PecaEntity) obj;
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
		PecaEntityStringSerializer.INSTANCE.serialize(this, sb, appended);
	}
	
}
