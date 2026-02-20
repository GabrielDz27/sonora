package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;


/**
 * Retorno de quantidade de peca trabalhada por funcionario para retornoRelatorio
 */
public class PecaFuncionario {
    
    @Valid
    public Peca peca;
    
    @Valid
    public Funcionario funcionario;
    
    
    public PecaFuncionario() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public PecaFuncionario(Peca peca, Funcionario funcionario) {
        this.peca = peca;
        this.funcionario = funcionario;
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
        if (funcionario != null) {
            ret = 31 * ret + funcionario.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PecaFuncionario)) {
            return false;
        }
        PecaFuncionario other = (PecaFuncionario) obj;
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
        return true;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	toString(sb, new ArrayList<>());
    	return sb.toString();
    }
    
    public void toString(StringBuilder sb, List<Object> appended) {
    	PecaFuncionarioStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
}
