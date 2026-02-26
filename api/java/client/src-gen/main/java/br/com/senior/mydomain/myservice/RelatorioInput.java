package br.com.senior.mydomain.myservice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;


public class RelatorioInput {

    public java.time.Instant dataInicio;
    
    @NotNull(message = "dataFinal is required")
    public java.time.Instant dataFinal;
    
    @NotNull(message = "tipoRelatorio is required")
    public TipoRelatorio tipoRelatorio;
    
    public TurnoFuncionario turno;
    
    public java.util.List<String> funcionario;
    
    public java.util.List<String> maquina;
    
    public java.util.List<String> codigoDesenho;
    
    
    public RelatorioInput() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public RelatorioInput(java.time.Instant dataInicio, java.time.Instant dataFinal, TipoRelatorio tipoRelatorio, TurnoFuncionario turno, java.util.List<String> funcionario, java.util.List<String> maquina, java.util.List<String> codigoDesenho) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.tipoRelatorio = tipoRelatorio;
        this.turno = turno;
        this.funcionario = funcionario;
        this.maquina = maquina;
        this.codigoDesenho = codigoDesenho;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public RelatorioInput(java.time.Instant dataInicio, java.time.Instant dataFinal, TipoRelatorio tipoRelatorio) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.tipoRelatorio = tipoRelatorio;
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
        if (dataInicio != null) {
            ret = 31 * ret + dataInicio.hashCode();
        }
        if (dataFinal != null) {
            ret = 31 * ret + dataFinal.hashCode();
        }
        if (tipoRelatorio != null) {
            ret = 31 * ret + tipoRelatorio.hashCode();
        }
        if (turno != null) {
            ret = 31 * ret + turno.hashCode();
        }
        if (funcionario != null) {
            ret = 31 * ret + funcionario.hashCode();
        }
        if (maquina != null) {
            ret = 31 * ret + maquina.hashCode();
        }
        if (codigoDesenho != null) {
            ret = 31 * ret + codigoDesenho.hashCode();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelatorioInput)) {
            return false;
        }
        RelatorioInput other = (RelatorioInput) obj;
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
        if ((tipoRelatorio == null) != (other.tipoRelatorio == null)) {
            return false;
        }
        if ((tipoRelatorio != null) && !tipoRelatorio.equals(other.tipoRelatorio)) {
            return false;
        }
        if ((turno == null) != (other.turno == null)) {
            return false;
        }
        if ((turno != null) && !turno.equals(other.turno)) {
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
        if ((codigoDesenho == null) != (other.codigoDesenho == null)) {
            return false;
        }
        if ((codigoDesenho != null) && !codigoDesenho.equals(other.codigoDesenho)) {
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
    	RelatorioInputStringSerializer.INSTANCE.serialize(this, sb, appended);
    }

}
