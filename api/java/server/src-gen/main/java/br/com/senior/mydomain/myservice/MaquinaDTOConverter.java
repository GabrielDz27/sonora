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

@Component("my_domain.my_service.MaquinaDTOConverter")
@Lazy
public class MaquinaDTOConverter {
	
	static final Logger logger = LoggerFactory.getLogger(MaquinaDTOConverter.class);
	
	
	public MaquinaEntity toEntity(Maquina dto, boolean createMethod) {
		MaquinaEntity ret = toEntity(dto, new HashMap<>());
		if(createMethod){
			ret.defineAsNewEntity();
		}
		return ret;
	}

	public MaquinaEntity toEntity(Maquina dto) {
		return toEntity(dto, new HashMap<>());
	}
	
	MaquinaEntity toEntity(Maquina dto, java.util.Map<Object, Object> converted) {
		if (dto == null) {
			return null;
		}
		MaquinaEntity entity = (MaquinaEntity) converted.get(dto);
		if (entity != null) {
			return entity;
		}
		entity = new MaquinaEntity();
		converted.put(dto, entity);
		return mergeEntity(entity, dto, converted);
	}
	
	public MaquinaEntity mergeEntity(MaquinaEntity entity, Maquina dto) {
		return mergeEntity(entity, dto, new HashMap<>());
	}
	
	MaquinaEntity mergeEntity(MaquinaEntity entity, Maquina dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		if (dto.nome != null) {
			entity.setNome(dto.nome);
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
	
	public MaquinaEntity updateEntity(MaquinaEntity entity, Maquina dto) {
		return updateEntity(entity, dto, new HashMap<>());
	}

	MaquinaEntity updateEntity(MaquinaEntity entity, Maquina dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		entity.setNome(dto.nome);
		entity.setStatus(dto.status);
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		return entity;
	}
	
	public java.util.List<MaquinaEntity> toEntityList(java.util.List<Maquina> dtos) {
		return toEntityList(dtos, new HashMap<>());
	}
	
	java.util.List<MaquinaEntity> toEntityList(java.util.List<Maquina> dtos, java.util.Map<Object, Object> converted) {
		java.util.List<MaquinaEntity> entities = null;
		if (dtos != null) {
			entities = dtos.stream().map(dto -> toEntity(dto, converted)).collect(Collectors.toList());
		}	
		return entities;
	}
	
	public Maquina toDTO(MaquinaEntity entity) {
		return toDTO(entity, new HashMap<>());
	}
	
	Maquina toDTO(MaquinaEntity entity, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		Maquina dto = (Maquina) converted.get(entity);
		if (dto != null) {
			return dto;
		}
        dto = new Maquina();
        converted.put(entity, dto);

		dto.id = entity.getId() != null ? entity.getId().toString() : null;
		dto.nome = entity.getNome();
		dto.status = entity.getStatus();
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
	
	public Maquina toDTO(MaquinaEntity entity, List<String> displayFields) {
		return toDTO(entity, displayFields, new HashMap<>());
	}
	
	Maquina toDTO(MaquinaEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}
		
		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));
		
        Maquina dto = new Maquina();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "nome".equals(displayField) || "*".equals(displayField))) {
			dto.nome = entity.getNome();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "status".equals(displayField) || "*".equals(displayField))) {
			dto.status = entity.getStatus();
		}
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
    
    Maquina toDTOforRelation(MaquinaEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}

		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));

        Maquina dto = new Maquina();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "nome".equals(displayField) || "*".equals(displayField))) {
			dto.nome = entity.getNome();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "status".equals(displayField) || "*".equals(displayField))) {
			dto.status = entity.getStatus();
		}
        return dto;
    }
    
    public java.util.List<Maquina> toDTOList(java.util.List<MaquinaEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Maquina> toDTOList(java.util.List<MaquinaEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Maquina> dtos = null;
    	if (entities != null) {
    		dtos = entities.stream().map(entity -> toDTO(entity, converted)).collect(Collectors.toList());
    	}
    	return dtos;
    }
    
    public java.util.List<Maquina> toDTOList(java.util.Set<MaquinaEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Maquina> toDTOList(java.util.Set<MaquinaEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Maquina> dtos = null;
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
	
	private void treatJsonPath(MaquinaEntity entity, JsonPatch jsonPatch) {
		if (!JsonPatch.REMOVE_OPERATION.equals(jsonPatch.getOp())){
			return;
		}
		
		if("id".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setId(null);
		}
		if("nome".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setNome(null);
		}
		if("status".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setStatus(null);
		}
	}
}
