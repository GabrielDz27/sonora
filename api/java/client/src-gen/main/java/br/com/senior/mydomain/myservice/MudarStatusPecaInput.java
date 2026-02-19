package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;


public class MudarStatusPecaInput {
    
    @NotNull(message = "id is required")
    public String id;
    
    @NotNull(message = "status is required")
    public StatusPeca status;
    
    
    public MudarStatusPecaInput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public MudarStatusPecaInput(String id, StatusPeca status) {
        this.id = id;
        this.status = status;
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
        if (status != null) {
            ret = 31 * ret + status.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MudarStatusPecaInput)) {
            return false;
        }
        MudarStatusPecaInput other = (MudarStatusPecaInput) obj;
        if ((id == null) != (other.id == null)) {
            return false;
        }
        if ((id != null) && !id.equals(other.id)) {
            return false;
        }
        if ((status == null) != (other.status == null)) {
            return false;
        }
        if ((status != null) && !status.equals(other.status)) {
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
    	MudarStatusPecaInputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
