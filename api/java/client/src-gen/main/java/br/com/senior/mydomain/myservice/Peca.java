package br.com.senior.mydomain.myservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.senior.messaging.model.EntityDescription;
import br.com.senior.messaging.model.EntityId;
import br.com.senior.custom.CustomDTO;

/**
 * Entidade da peça com as informações
 */
@EntityDescription
public class Peca extends CustomDTO {
    
    public static class Id {
    	
        public String id;
        
        public Id() {
        }
        
        public Id(String pecaId) {
            this.id = pecaId;
        }
        
        public String getPecaId() {
            return id;
        }
        
        public String getId() {
            return id;
        }
        
    	public void normalize(Map<String, Object> headers) {
    		MyServiceNormalizer.normalize(this, headers);
    	}
    	
    }
    
    public static class PagedResults {
    	public Long totalPages;
    	public Long totalElements;
    	
        public List<Peca> contents;
        
        public PagedResults() {
        }
        
        public PagedResults(List<Peca> contents) {
            this.contents = contents;
        }
        
        public PagedResults(List<Peca> contents, Long totalPages, Long totalElements) {
            this.contents = contents;
            this.totalPages = totalPages;
            this.totalElements = totalElements;
        }
    }
    
    public static class PageRequest {
        public Long offset;
        public Long size;
        public boolean translations;
        public String orderBy;
        public String filter;
        public List<String> displayFields;
        
        public PageRequest() {
        }
        
        public PageRequest(Long offset, Long size) {
            this(offset, size, null, null);
        }
        
        public PageRequest(Long offset, Long size, String orderBy) {
            this(offset, size, orderBy, null);
        }
        
        public PageRequest(Long offset, Long size, String orderBy, String filter) {
            this(offset, size, orderBy, filter, null);
       	}
        
        public PageRequest(Long offset, Long size, String orderBy, String filter, List<String> displayFields) {
            this.offset = offset;
        	this.size = size;
        	this.orderBy = orderBy;
        	this.filter = filter;
        	this.displayFields = displayFields;
        }
    }
    			    
    public static class GetRequest {
        public String id;
        public List<String> displayFields;
        public boolean translations;
        
        public GetRequest() {
        }
        
        public GetRequest(String id) {
            this(id, null);
        }
        
        public GetRequest(String id, List<String> displayFields) {
            this.id = id;
            this.displayFields = displayFields;
        }
    }

    @EntityId
    /**
     * Identificador único UUID
     */
    public String id;
    
    /**
     * Nome descritivo do item
     */
    @NotNull(message = "nome is required")
    @Size(max = 100, message = "nome max length is {max}")
    public String nome;
    
    /**
     * Referência técnica do projeto
     */
    @NotNull(message = "codigoDesenho is required")
    @Size(max = 50, message = "codigoDesenho max length is {max}")
    public String codigoDesenho;
    
    /**
     * Tempo previsto para fabricação
     */
    @NotNull(message = "tempoEstimadoMinutos is required")
    public Long tempoEstimadoMinutos;
    
    /**
     * Estado atual: PENDENTE, PROCESSO, FINALIZADO, MORTA
     */
    @NotNull(message = "status is required")
    public StatusPeca status;
    
    /**
     * Valor da peça
     */
    @NotNull(message = "valor is required")
    public java.math.BigDecimal valor;
    
    /**
     * Motivo pela perda peça quando o status da peça é morta
     */
    @NotNull(message = "motivoPerda is required")
    public String motivoPerda;
    
    
	private List<JsonPatch> jsonPatches;
	
    public Peca() {
    }
    
    /** 
     * This constructor allows initialization of all fields, required and optional.
     */
    public Peca(String id, String nome, String codigoDesenho, Long tempoEstimadoMinutos, StatusPeca status, java.math.BigDecimal valor, String motivoPerda, List<JsonPatch> jsonPatches) {
        this.id = id;
        this.nome = nome;
        this.codigoDesenho = codigoDesenho;
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
        this.status = status;
        this.valor = valor;
        this.motivoPerda = motivoPerda;
        this.jsonPatches = jsonPatches;
    }
    /** 
     * This convenience constructor allows initialization of all required fields.
     */
    public Peca(String nome, String codigoDesenho, Long tempoEstimadoMinutos, StatusPeca status, java.math.BigDecimal valor, String motivoPerda) {
        this.nome = nome;
        this.codigoDesenho = codigoDesenho;
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
        this.status = status;
        this.valor = valor;
        this.motivoPerda = motivoPerda;
    }
    
    public void normalize(Map<String, Object> headers) {
    	MyServiceNormalizer.normalize(this, headers);
    }
    
    public void validate() {
    	validate(true);
    }
    
    public void validate(boolean required) {
    	validate(null, true);
    }
    
    public void validate(Map<String, Object> headers, boolean required) {
    	validate(headers, required, new ArrayList<>());
    }
    
    void validate(Map<String, Object> headers, boolean required, List<Object> validated) {
    	MyServiceValidator.validate(this, headers, required, validated);
    }
    @Override
    public int hashCode() {
        int ret = 1;
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
        if (!(obj instanceof Peca)) {
            return false;
        }
        Peca other = (Peca) obj;
        if (id == null || !id.equals(other.id)) {
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
    	PecaStringSerializer.INSTANCE.serialize(this, sb, appended);
    }
    
	
    public List<JsonPatch> getJsonPatches(){
    	return jsonPatches == null ? java.util.Collections.emptyList() : jsonPatches;
    }
}
