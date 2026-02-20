package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;


public class GetMaquinaAtivaOutput {
    
    @Valid
    public java.util.List<Maquina> maquina;
    
    
    public GetMaquinaAtivaOutput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public GetMaquinaAtivaOutput(java.util.List<Maquina> maquina) {
        this.maquina = maquina;
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
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetMaquinaAtivaOutput)) {
            return false;
        }
        GetMaquinaAtivaOutput other = (GetMaquinaAtivaOutput) obj;
        if ((maquina == null) != (other.maquina == null)) {
            return false;
        }
        if ((maquina != null) && !maquina.equals(other.maquina)) {
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
    	GetMaquinaAtivaOutputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
