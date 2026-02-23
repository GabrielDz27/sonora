package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;


public class RetornaIdFuncionarioInput {
    
    @NotNull(message = "username is required")
    public String username;
    
    
    public RetornaIdFuncionarioInput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public RetornaIdFuncionarioInput(String username) {
        this.username = username;
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
        if (username != null) {
            ret = 31 * ret + username.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetornaIdFuncionarioInput)) {
            return false;
        }
        RetornaIdFuncionarioInput other = (RetornaIdFuncionarioInput) obj;
        if ((username == null) != (other.username == null)) {
            return false;
        }
        if ((username != null) && !username.equals(other.username)) {
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
    	RetornaIdFuncionarioInputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
