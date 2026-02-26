package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;


/**
 * Record para retorna uma lista de registroProducao
 */
public class RecordRegistroProducao {
    
    public String id;
    
    @NotNull(message = "peca is required")
    @Valid
    public Peca peca;
    
    @NotNull(message = "funcionario is required")
    @Valid
    public Funcionario funcionario;
    
    @NotNull(message = "maquina is required")
    @Valid
    public Maquina maquina;
    
    @NotNull(message = "dataInicio is required")
    public java.time.Instant dataInicio;
    
    public java.time.Instant dataFinal;
    
    
    public RecordRegistroProducao() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public RecordRegistroProducao(String id, Peca peca, Funcionario funcionario, Maquina maquina, java.time.Instant dataInicio, java.time.Instant dataFinal) {
        this.id = id;
        this.peca = peca;
        this.funcionario = funcionario;
        this.maquina = maquina;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public RecordRegistroProducao(Peca peca, Funcionario funcionario, Maquina maquina, java.time.Instant dataInicio) {
        this.peca = peca;
        this.funcionario = funcionario;
        this.maquina = maquina;
        this.dataInicio = dataInicio;
    }
    
    public void validate() {
        validate(true);
    }
    
    public void validate(boolean required) {
        validate(null, required);
    }
    
    public void validate(Map<String, Object> headers, boolean required) {
    	validate(headers, required, new ArrayList<>());
    }
    
    public void validate(Map<String, Object> headers, boolean required, List<Object> validated) {
    	MyServiceValidator.validate(this, headers, required, validated);
    }
    @Override
    public int hashCode() {
        int ret = 1;
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        if (peca != null) {
            ret = 31 * ret + peca.hashCode();
        }
        if (funcionario != null) {
            ret = 31 * ret + funcionario.hashCode();
        }
        if (maquina != null) {
            ret = 31 * ret + maquina.hashCode();
        }
        if (dataInicio != null) {
            ret = 31 * ret + dataInicio.hashCode();
        }
        if (dataFinal != null) {
            ret = 31 * ret + dataFinal.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordRegistroProducao)) {
            return false;
        }
        RecordRegistroProducao other = (RecordRegistroProducao) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        if ((peca == null) != (other.peca == null)) {
            return false;
        }
        if ((peca != null) && !peca.equals(other.peca)) {
            return false;
        }
        if ((funcionario == null) != (other.funcionario == null)) {
            return false;
        }
        if ((funcionario != null) && !funcionario.equals(other.funcionario)) {
            return false;
        }
        if ((maquina == null) != (other.maquina == null)) {
            return false;
        }
        if ((maquina != null) && !maquina.equals(other.maquina)) {
            return false;
        }
        if ((dataInicio == null) != (other.dataInicio == null)) {
            return false;
        }
        if ((dataInicio != null) && !dataInicio.equals(other.dataInicio)) {
            return false;
        }
        if ((dataFinal == null) != (other.dataFinal == null)) {
            return false;
        }
        if ((dataFinal != null) && !dataFinal.equals(other.dataFinal)) {
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
    
    public void toString(StringBuilder sb, List<Object> appended) {
    	RecordRegistroProducaoStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
