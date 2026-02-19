package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;


public class MaquinaTrabalhando {
    
    @Valid
    public Maquina maquina;
    
    @NotNull(message = "horas is required")
    @Min(value = 0L, message = "horas min value is {value}")
    public Long horas;
    
    
    public MaquinaTrabalhando() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public MaquinaTrabalhando(Maquina maquina, Long horas) {
        this.maquina = maquina;
        this.horas = horas;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public MaquinaTrabalhando(Long horas) {
        this.horas = horas;
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
        if (maquina != null) {
            ret = 31 * ret + maquina.hashCode();
        }
        if (horas != null) {
            ret = 31 * ret + horas.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaquinaTrabalhando)) {
            return false;
        }
        MaquinaTrabalhando other = (MaquinaTrabalhando) obj;
        if ((maquina == null) != (other.maquina == null)) {
            return false;
        }
        if ((maquina != null) && !maquina.equals(other.maquina)) {
            return false;
        }
        if ((horas == null) != (other.horas == null)) {
            return false;
        }
        if ((horas != null) && !horas.equals(other.horas)) {
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
    	MaquinaTrabalhandoStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
