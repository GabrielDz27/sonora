package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;


public class RetornaIdFuncionarioOutput {
    
    @NotNull(message = "nome is required")
    public String nome;
    
    @NotNull(message = "id is required")
    public String id;
    
    
    public RetornaIdFuncionarioOutput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public RetornaIdFuncionarioOutput(String nome, String id) {
        this.nome = nome;
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
        if (nome != null) {
            ret = 31 * ret + nome.hashCode();
        }
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
        if (!(obj instanceof RetornaIdFuncionarioOutput)) {
            return false;
        }
        RetornaIdFuncionarioOutput other = (RetornaIdFuncionarioOutput) obj;
        if ((nome == null) != (other.nome == null)) {
            return false;
        }
        if ((nome != null) && !nome.equals(other.nome)) {
            return false;
        }
        if ((id == null) != (other.id == null)) {
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
    
    public void toString(StringBuilder sb, List<Object> appended) {
    	RetornaIdFuncionarioOutputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
