package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;


/**
 * Retorno do endpoint do relatorio com seus records conforme os dados
 */
public class RetornoRelatorio {
    
    @Valid
    public java.util.List<MaquinaTrabalhando> maquinaTrabalhando;
    
    @NotNull(message = "pecaMortas is required")
    @Min(value = 0L, message = "pecaMortas min value is {value}")
    public Long pecaMortas;
    
    @Valid
    public java.util.List<PecaFuncionario> pecaFuncionario;
    
    
    public RetornoRelatorio() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public RetornoRelatorio(java.util.List<MaquinaTrabalhando> maquinaTrabalhando, Long pecaMortas, java.util.List<PecaFuncionario> pecaFuncionario) {
        this.maquinaTrabalhando = maquinaTrabalhando;
        this.pecaMortas = pecaMortas;
        this.pecaFuncionario = pecaFuncionario;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public RetornoRelatorio(Long pecaMortas) {
        this.pecaMortas = pecaMortas;
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
        if (maquinaTrabalhando != null) {
            ret = 31 * ret + maquinaTrabalhando.hashCode();
        }
        if (pecaMortas != null) {
            ret = 31 * ret + pecaMortas.hashCode();
        }
        if (pecaFuncionario != null) {
            ret = 31 * ret + pecaFuncionario.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetornoRelatorio)) {
            return false;
        }
        RetornoRelatorio other = (RetornoRelatorio) obj;
        if ((maquinaTrabalhando == null) != (other.maquinaTrabalhando == null)) {
            return false;
        }
        if ((maquinaTrabalhando != null) && !maquinaTrabalhando.equals(other.maquinaTrabalhando)) {
            return false;
        }
        if ((pecaMortas == null) != (other.pecaMortas == null)) {
            return false;
        }
        if ((pecaMortas != null) && !pecaMortas.equals(other.pecaMortas)) {
            return false;
        }
        if ((pecaFuncionario == null) != (other.pecaFuncionario == null)) {
            return false;
        }
        if ((pecaFuncionario != null) && !pecaFuncionario.equals(other.pecaFuncionario)) {
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
    	RetornoRelatorioStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
