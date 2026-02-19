/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;

@Component("my_domain.my_service.PecaDTOConverter")
@Lazy
public class PecaDTOConverter {
	
	static final Logger logger = LoggerFactory.getLogger(PecaDTOConverter.class);
	
	
	public PecaEntity toEntity(Peca dto, boolean createMethod) {
		PecaEntity ret = toEntity(dto, new HashMap<>());
		if(createMethod){
			ret.defineAsNewEntity();
		}
		return ret;
	}

	public PecaEntity toEntity(Peca dto) {
		return toEntity(dto, new HashMap<>());
	}
	
	PecaEntity toEntity(Peca dto, java.util.Map<Object, Object> converted) {
		if (dto == null) {
			return null;
		}
		PecaEntity entity = (PecaEntity) converted.get(dto);
		if (entity != null) {
			return entity;
		}
		entity = new PecaEntity();
		converted.put(dto, entity);
		return mergeEntity(entity, dto, converted);
	}
	
	public PecaEntity mergeEntity(PecaEntity entity, Peca dto) {
		return mergeEntity(entity, dto, new HashMap<>());
	}
	
	PecaEntity mergeEntity(PecaEntity entity, Peca dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		if (dto.nome != null) {
			entity.setNome(dto.nome);
		}
		if (dto.codigoDesenho != null) {
			entity.setCodigoDesenho(dto.codigoDesenho);
		}
		if (dto.tempoEstimadoMinutos != null) {
			entity.setTempoEstimadoMinutos(dto.tempoEstimadoMinutos);
		}
		if (dto.status != null) {
			entity.setStatus(dto.status);
		}
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		
        for (JsonPatch jsonPatch : dto.getJsonPatches()) {
            treatJsonPath(entity, jsonPatch);
        }
		
		return entity;
	}
	
	public PecaEntity updateEntity(PecaEntity entity, Peca dto) {
		return updateEntity(entity, dto, new HashMap<>());
	}

	PecaEntity updateEntity(PecaEntity entity, Peca dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		entity.setNome(dto.nome);
		entity.setCodigoDesenho(dto.codigoDesenho);
		entity.setTempoEstimadoMinutos(dto.tempoEstimadoMinutos);
		entity.setStatus(dto.status);
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		return entity;
	}
	
	public java.util.List<PecaEntity> toEntityList(java.util.List<Peca> dtos) {
		return toEntityList(dtos, new HashMap<>());
	}
	
	java.util.List<PecaEntity> toEntityList(java.util.List<Peca> dtos, java.util.Map<Object, Object> converted) {
		java.util.List<PecaEntity> entities = null;
		if (dtos != null) {
			entities = dtos.stream().map(dto -> toEntity(dto, converted)).collect(Collectors.toList());
		}	
		return entities;
	}
	
	public Peca toDTO(PecaEntity entity) {
		return toDTO(entity, new HashMap<>());
	}
	
	Peca toDTO(PecaEntity entity, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		Peca dto = (Peca) converted.get(entity);
		if (dto != null) {
			return dto;
		}
        dto = new Peca();
        converted.put(entity, dto);

		dto.id = entity.getId() != null ? entity.getId().toString() : null;
		dto.nome = entity.getNome();
		dto.codigoDesenho = entity.getCodigoDesenho();
		dto.tempoEstimadoMinutos = entity.getTempoEstimadoMinutos();
		dto.status = entity.getStatus();
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
	
	public Peca toDTO(PecaEntity entity, List<String> displayFields) {
		return toDTO(entity, displayFields, new HashMap<>());
	}
	
	Peca toDTO(PecaEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}
		
		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));
		
        Peca dto = new Peca();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "nome".equals(displayField) || "*".equals(displayField))) {
			dto.nome = entity.getNome();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "codigoDesenho".equals(displayField) || "*".equals(displayField))) {
			dto.codigoDesenho = entity.getCodigoDesenho();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "tempoEstimadoMinutos".equals(displayField) || "*".equals(displayField))) {
			dto.tempoEstimadoMinutos = entity.getTempoEstimadoMinutos();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "status".equals(displayField) || "*".equals(displayField))) {
			dto.status = entity.getStatus();
		}
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
    
    Peca toDTOforRelation(PecaEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}

		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));

        Peca dto = new Peca();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "nome".equals(displayField) || "*".equals(displayField))) {
			dto.nome = entity.getNome();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "codigoDesenho".equals(displayField) || "*".equals(displayField))) {
			dto.codigoDesenho = entity.getCodigoDesenho();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "tempoEstimadoMinutos".equals(displayField) || "*".equals(displayField))) {
			dto.tempoEstimadoMinutos = entity.getTempoEstimadoMinutos();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "status".equals(displayField) || "*".equals(displayField))) {
			dto.status = entity.getStatus();
		}
        return dto;
    }
    
    public java.util.List<Peca> toDTOList(java.util.List<PecaEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Peca> toDTOList(java.util.List<PecaEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Peca> dtos = null;
    	if (entities != null) {
    		dtos = entities.stream().map(entity -> toDTO(entity, converted)).collect(Collectors.toList());
    	}
    	return dtos;
    }
    
    public java.util.List<Peca> toDTOList(java.util.Set<PecaEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Peca> toDTOList(java.util.Set<PecaEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Peca> dtos = null;
    	if (entities != null) {
    		dtos = entities.stream().map(entity -> toDTO(entity, converted)).collect(Collectors.toList());
    	}
    	return dtos;
    }
    
        
	private static Set<Field> findFields(Class<?> clazz, Class<? extends Annotation> ann) {
		Set<Field> set = new HashSet<>();
		Class<?> c = clazz;
		while (c != null) {
			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(ann)) {
					set.add(field);
				}
			}
			c = c.getSuperclass();
		}
		return set;
	}
	
	private void treatJsonPath(PecaEntity entity, JsonPatch jsonPatch) {
		if (!JsonPatch.REMOVE_OPERATION.equals(jsonPatch.getOp())){
			return;
		}
		
		if("id".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setId(null);
		}
		if("nome".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setNome(null);
		}
		if("codigoDesenho".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setCodigoDesenho(null);
		}
		if("tempoEstimadoMinutos".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setTempoEstimadoMinutos(null);
		}
		if("status".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setStatus(null);
		}
	}
}
