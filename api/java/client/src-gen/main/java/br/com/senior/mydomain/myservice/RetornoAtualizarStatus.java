package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;


/**
 * Retorno Dos status atualizado, generico para quando usar em outros actions
 */
public class RetornoAtualizarStatus {
    
    @NotNull(message = "mensagemRetorno is required")
    public String mensagemRetorno;
    
    @NotNull(message = "id is required")
    public String id;
    
    public Boolean contemErro;
    
    
    public RetornoAtualizarStatus() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public RetornoAtualizarStatus(String mensagemRetorno, String id, Boolean contemErro) {
        this.mensagemRetorno = mensagemRetorno;
        this.id = id;
        this.contemErro = contemErro;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public RetornoAtualizarStatus(String mensagemRetorno, String id) {
        this.mensagemRetorno = mensagemRetorno;
        this.id = id;
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
        if (mensagemRetorno != null) {
            ret = 31 * ret + mensagemRetorno.hashCode();
        }
        if (id != null) {
            ret = 31 * ret + id.hashCode();
        }
        if (contemErro != null) {
            ret = 31 * ret + contemErro.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetornoAtualizarStatus)) {
            return false;
        }
        RetornoAtualizarStatus other = (RetornoAtualizarStatus) obj;
        if ((mensagemRetorno == null) != (other.mensagemRetorno == null)) {
            return false;
        }
        if ((mensagemRetorno != null) && !mensagemRetorno.equals(other.mensagemRetorno)) {
            return false;
        }
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        if ((contemErro == null) != (other.contemErro == null)) {
            return false;
        }
        if ((contemErro != null) && !contemErro.equals(other.contemErro)) {
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
    	RetornoAtualizarStatusStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
