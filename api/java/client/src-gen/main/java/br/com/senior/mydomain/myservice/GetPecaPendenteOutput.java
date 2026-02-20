package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;


public class GetPecaPendenteOutput {
    
    @Valid
    public java.util.List<Peca> peca;
    
    
    public GetPecaPendenteOutput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public GetPecaPendenteOutput(java.util.List<Peca> peca) {
        this.peca = peca;
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
        if (peca != null) {
            ret = 31 * ret + peca.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPecaPendenteOutput)) {
            return false;
        }
        GetPecaPendenteOutput other = (GetPecaPendenteOutput) obj;
        if ((peca == null) != (other.peca == null)) {
            return false;
        }
        if ((peca != null) && !peca.equals(other.peca)) {
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
    	GetPecaPendenteOutputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
