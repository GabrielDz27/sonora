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

@Component("my_domain.my_service.FuncionarioDTOConverter")
@Lazy
public class FuncionarioDTOConverter {
	
	static final Logger logger = LoggerFactory.getLogger(FuncionarioDTOConverter.class);
	
	
	public FuncionarioEntity toEntity(Funcionario dto, boolean createMethod) {
		FuncionarioEntity ret = toEntity(dto, new HashMap<>());
		if(createMethod){
			ret.defineAsNewEntity();
		}
		return ret;
	}

	public FuncionarioEntity toEntity(Funcionario dto) {
		return toEntity(dto, new HashMap<>());
	}
	
	FuncionarioEntity toEntity(Funcionario dto, java.util.Map<Object, Object> converted) {
		if (dto == null) {
			return null;
		}
		FuncionarioEntity entity = (FuncionarioEntity) converted.get(dto);
		if (entity != null) {
			return entity;
		}
		entity = new FuncionarioEntity();
		converted.put(dto, entity);
		return mergeEntity(entity, dto, converted);
	}
	
	public FuncionarioEntity mergeEntity(FuncionarioEntity entity, Funcionario dto) {
		return mergeEntity(entity, dto, new HashMap<>());
	}
	
	FuncionarioEntity mergeEntity(FuncionarioEntity entity, Funcionario dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		if (dto.nome != null) {
			entity.setNome(dto.nome);
		}
		if (dto.matricula != null) {
			entity.setMatricula(dto.matricula);
		}
		if (dto.cargo != null) {
			entity.setCargo(dto.cargo);
		}
		if (dto.turno != null) {
			entity.setTurno(dto.turno);
		}
		if (dto.ativo != null) {
			entity.setAtivo(dto.ativo);
		}
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		
        for (JsonPatch jsonPatch : dto.getJsonPatches()) {
            treatJsonPath(entity, jsonPatch);
        }
		
		return entity;
	}
	
	public FuncionarioEntity updateEntity(FuncionarioEntity entity, Funcionario dto) {
		return updateEntity(entity, dto, new HashMap<>());
	}

	FuncionarioEntity updateEntity(FuncionarioEntity entity, Funcionario dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		entity.setNome(dto.nome);
		entity.setMatricula(dto.matricula);
		entity.setCargo(dto.cargo);
		entity.setTurno(dto.turno);
		entity.setAtivo(dto.ativo);
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		return entity;
	}
	
	public java.util.List<FuncionarioEntity> toEntityList(java.util.List<Funcionario> dtos) {
		return toEntityList(dtos, new HashMap<>());
	}
	
	java.util.List<FuncionarioEntity> toEntityList(java.util.List<Funcionario> dtos, java.util.Map<Object, Object> converted) {
		java.util.List<FuncionarioEntity> entities = null;
		if (dtos != null) {
			entities = dtos.stream().map(dto -> toEntity(dto, converted)).collect(Collectors.toList());
		}	
		return entities;
	}
	
	public Funcionario toDTO(FuncionarioEntity entity) {
		return toDTO(entity, new HashMap<>());
	}
	
	Funcionario toDTO(FuncionarioEntity entity, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		Funcionario dto = (Funcionario) converted.get(entity);
		if (dto != null) {
			return dto;
		}
        dto = new Funcionario();
        converted.put(entity, dto);

		dto.id = entity.getId() != null ? entity.getId().toString() : null;
		dto.nome = entity.getNome();
		dto.matricula = entity.getMatricula();
		dto.cargo = entity.getCargo();
		dto.turno = entity.getTurno();
		dto.ativo = entity.getAtivo();
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
	
	public Funcionario toDTO(FuncionarioEntity entity, List<String> displayFields) {
		return toDTO(entity, displayFields, new HashMap<>());
	}
	
	Funcionario toDTO(FuncionarioEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}
		
		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));
		
        Funcionario dto = new Funcionario();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "nome".equals(displayField) || "*".equals(displayField))) {
			dto.nome = entity.getNome();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "matricula".equals(displayField) || "*".equals(displayField))) {
			dto.matricula = entity.getMatricula();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "cargo".equals(displayField) || "*".equals(displayField))) {
			dto.cargo = entity.getCargo();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "turno".equals(displayField) || "*".equals(displayField))) {
			dto.turno = entity.getTurno();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "ativo".equals(displayField) || "*".equals(displayField))) {
			dto.ativo = entity.getAtivo();
		}
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
    
    Funcionario toDTOforRelation(FuncionarioEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}

		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));

        Funcionario dto = new Funcionario();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		if (displayFields.stream().anyMatch(displayField -> "nome".equals(displayField) || "*".equals(displayField))) {
			dto.nome = entity.getNome();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "matricula".equals(displayField) || "*".equals(displayField))) {
			dto.matricula = entity.getMatricula();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "cargo".equals(displayField) || "*".equals(displayField))) {
			dto.cargo = entity.getCargo();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "turno".equals(displayField) || "*".equals(displayField))) {
			dto.turno = entity.getTurno();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "ativo".equals(displayField) || "*".equals(displayField))) {
			dto.ativo = entity.getAtivo();
		}
        return dto;
    }
    
    public java.util.List<Funcionario> toDTOList(java.util.List<FuncionarioEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Funcionario> toDTOList(java.util.List<FuncionarioEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Funcionario> dtos = null;
    	if (entities != null) {
    		dtos = entities.stream().map(entity -> toDTO(entity, converted)).collect(Collectors.toList());
    	}
    	return dtos;
    }
    
    public java.util.List<Funcionario> toDTOList(java.util.Set<FuncionarioEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<Funcionario> toDTOList(java.util.Set<FuncionarioEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<Funcionario> dtos = null;
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
	
	private void treatJsonPath(FuncionarioEntity entity, JsonPatch jsonPatch) {
		if (!JsonPatch.REMOVE_OPERATION.equals(jsonPatch.getOp())){
			return;
		}
		
		if("id".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setId(null);
		}
		if("nome".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setNome(null);
		}
		if("matricula".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setMatricula(null);
		}
		if("cargo".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setCargo(null);
		}
		if("turno".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setTurno(null);
		}
		if("ativo".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setAtivo(null);
		}
	}
}
