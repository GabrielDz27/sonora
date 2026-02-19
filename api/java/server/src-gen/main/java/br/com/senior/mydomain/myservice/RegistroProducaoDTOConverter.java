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
import javax.inject.Inject;
import javax.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Lazy;

@Component("my_domain.my_service.RegistroProducaoDTOConverter")
@Lazy
public class RegistroProducaoDTOConverter {
	
	static final Logger logger = LoggerFactory.getLogger(RegistroProducaoDTOConverter.class);
	
	private PecaDTOConverter pecaDTOConverter;
	private FuncionarioDTOConverter funcionarioDTOConverter;
	private MaquinaDTOConverter maquinaDTOConverter;
	
	@Inject
	public void setPecaDTOConverter(PecaDTOConverter pecaDTOConverter) {
		this.pecaDTOConverter = pecaDTOConverter;
	}
	
	@Inject
	public void setFuncionarioDTOConverter(FuncionarioDTOConverter funcionarioDTOConverter) {
		this.funcionarioDTOConverter = funcionarioDTOConverter;
	}
	
	@Inject
	public void setMaquinaDTOConverter(MaquinaDTOConverter maquinaDTOConverter) {
		this.maquinaDTOConverter = maquinaDTOConverter;
	}
	
	public RegistroProducaoEntity toEntity(RegistroProducao dto, boolean createMethod) {
		RegistroProducaoEntity ret = toEntity(dto, new HashMap<>());
		if(createMethod){
			ret.defineAsNewEntity();
		}
		return ret;
	}

	public RegistroProducaoEntity toEntity(RegistroProducao dto) {
		return toEntity(dto, new HashMap<>());
	}
	
	RegistroProducaoEntity toEntity(RegistroProducao dto, java.util.Map<Object, Object> converted) {
		if (dto == null) {
			return null;
		}
		RegistroProducaoEntity entity = (RegistroProducaoEntity) converted.get(dto);
		if (entity != null) {
			return entity;
		}
		entity = new RegistroProducaoEntity();
		converted.put(dto, entity);
		return mergeEntity(entity, dto, converted);
	}
	
	public RegistroProducaoEntity mergeEntity(RegistroProducaoEntity entity, RegistroProducao dto) {
		return mergeEntity(entity, dto, new HashMap<>());
	}
	
	RegistroProducaoEntity mergeEntity(RegistroProducaoEntity entity, RegistroProducao dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		if (dto.peca != null) {
			entity.setPeca(pecaDTOConverter.toEntity(dto.peca, converted));
		}
		
		if (dto.funcionario != null) {
			entity.setFuncionario(funcionarioDTOConverter.toEntity(dto.funcionario, converted));
		}
		
		if (dto.maquina != null) {
			entity.setMaquina(maquinaDTOConverter.toEntity(dto.maquina, converted));
		}
		
		if (dto.dataInicio != null) {
			entity.setDataInicio(dto.dataInicio);
		}
		if (dto.dataFinal != null) {
			entity.setDataFinal(dto.dataFinal);
		}
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		
        for (JsonPatch jsonPatch : dto.getJsonPatches()) {
            treatJsonPath(entity, jsonPatch);
        }
		
		return entity;
	}
	
	public RegistroProducaoEntity updateEntity(RegistroProducaoEntity entity, RegistroProducao dto) {
		return updateEntity(entity, dto, new HashMap<>());
	}

	RegistroProducaoEntity updateEntity(RegistroProducaoEntity entity, RegistroProducao dto, java.util.Map<Object, Object> converted) {
		if (dto.id != null) {
			entity.setId(java.util.UUID.fromString(dto.id));
		}
		entity.setPeca(pecaDTOConverter.toEntity(dto.peca, converted));
		
		entity.setFuncionario(funcionarioDTOConverter.toEntity(dto.funcionario, converted));
		
		entity.setMaquina(maquinaDTOConverter.toEntity(dto.maquina, converted));
		
		entity.setDataInicio(dto.dataInicio);
		entity.setDataFinal(dto.dataFinal);
		for (Map.Entry<String, Object> entry : dto.getCustom().entrySet()) {
			entity.setCustom(entry.getKey(), entry.getValue());
		}
		return entity;
	}
	
	public java.util.List<RegistroProducaoEntity> toEntityList(java.util.List<RegistroProducao> dtos) {
		return toEntityList(dtos, new HashMap<>());
	}
	
	java.util.List<RegistroProducaoEntity> toEntityList(java.util.List<RegistroProducao> dtos, java.util.Map<Object, Object> converted) {
		java.util.List<RegistroProducaoEntity> entities = null;
		if (dtos != null) {
			entities = dtos.stream().map(dto -> toEntity(dto, converted)).collect(Collectors.toList());
		}	
		return entities;
	}
	
	public RegistroProducao toDTO(RegistroProducaoEntity entity) {
		return toDTO(entity, new HashMap<>());
	}
	
	RegistroProducao toDTO(RegistroProducaoEntity entity, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		RegistroProducao dto = (RegistroProducao) converted.get(entity);
		if (dto != null) {
			return dto;
		}
        dto = new RegistroProducao();
        converted.put(entity, dto);

		dto.id = entity.getId() != null ? entity.getId().toString() : null;
		dto.peca = pecaDTOConverter.toDTO(entity.getPeca(), converted);
		dto.funcionario = funcionarioDTOConverter.toDTO(entity.getFuncionario(), converted);
		dto.maquina = maquinaDTOConverter.toDTO(entity.getMaquina(), converted);
		dto.dataInicio = entity.getDataInicio();
		dto.dataFinal = entity.getDataFinal();
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
	
	public RegistroProducao toDTO(RegistroProducaoEntity entity, List<String> displayFields) {
		return toDTO(entity, displayFields, new HashMap<>());
	}
	
	RegistroProducao toDTO(RegistroProducaoEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}
		
		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));
		
        RegistroProducao dto = new RegistroProducao();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		List<String> pecaDisplayFields = displayFields.stream()
						.filter(displayField -> displayField.trim().startsWith("peca.")).map(f -> f.substring("peca.".length() + f.indexOf("peca.")).trim()).collect(Collectors.toList());
		if (!pecaDisplayFields.isEmpty()) {
			dto.peca = pecaDTOConverter.toDTO(entity.getPeca(), pecaDisplayFields, new java.util.HashMap<Object, Object>());
		}
		
		List<String> funcionarioDisplayFields = displayFields.stream()
						.filter(displayField -> displayField.trim().startsWith("funcionario.")).map(f -> f.substring("funcionario.".length() + f.indexOf("funcionario.")).trim()).collect(Collectors.toList());
		if (!funcionarioDisplayFields.isEmpty()) {
			dto.funcionario = funcionarioDTOConverter.toDTO(entity.getFuncionario(), funcionarioDisplayFields, new java.util.HashMap<Object, Object>());
		}
		
		List<String> maquinaDisplayFields = displayFields.stream()
						.filter(displayField -> displayField.trim().startsWith("maquina.")).map(f -> f.substring("maquina.".length() + f.indexOf("maquina.")).trim()).collect(Collectors.toList());
		if (!maquinaDisplayFields.isEmpty()) {
			dto.maquina = maquinaDTOConverter.toDTO(entity.getMaquina(), maquinaDisplayFields, new java.util.HashMap<Object, Object>());
		}
		
		if (displayFields.stream().anyMatch(displayField -> "dataInicio".equals(displayField) || "*".equals(displayField))) {
			dto.dataInicio = entity.getDataInicio();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "dataFinal".equals(displayField) || "*".equals(displayField))) {
			dto.dataFinal = entity.getDataFinal();
		}
		for(String customField : entity.getCustomFields()) {
			dto.setCustom(customField, entity.getCustom(customField));
		}
        return dto;
    }
    
    RegistroProducao toDTOforRelation(RegistroProducaoEntity entity, List<String> displayFields, java.util.Map<Object, Object> converted) {
		if (entity == null) {
			return null;
		}
		if (displayFields == null) {
			return toDTO(entity, converted);
		}

		Set<Field> ids = findFields(entity.getClass(), Id.class);
		displayFields.addAll(ids.stream().map(field -> field.getName()).collect(Collectors.toList()));

        RegistroProducao dto = new RegistroProducao();
		if (displayFields.stream().anyMatch(displayField -> "id".equals(displayField) || "*".equals(displayField))) {
			dto.id = entity.getId() != null ? entity.getId().toString() : null;
		}
		
		
		
		
		if (displayFields.stream().anyMatch(displayField -> "dataInicio".equals(displayField) || "*".equals(displayField))) {
			dto.dataInicio = entity.getDataInicio();
		}
		
		if (displayFields.stream().anyMatch(displayField -> "dataFinal".equals(displayField) || "*".equals(displayField))) {
			dto.dataFinal = entity.getDataFinal();
		}
        return dto;
    }
    
    public java.util.List<RegistroProducao> toDTOList(java.util.List<RegistroProducaoEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<RegistroProducao> toDTOList(java.util.List<RegistroProducaoEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<RegistroProducao> dtos = null;
    	if (entities != null) {
    		dtos = entities.stream().map(entity -> toDTO(entity, converted)).collect(Collectors.toList());
    	}
    	return dtos;
    }
    
    public java.util.List<RegistroProducao> toDTOList(java.util.Set<RegistroProducaoEntity> entities) {
    	return toDTOList(entities, new HashMap<>());
    }
    
    java.util.List<RegistroProducao> toDTOList(java.util.Set<RegistroProducaoEntity> entities, java.util.Map<Object, Object> converted) {
    	java.util.List<RegistroProducao> dtos = null;
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
	
	private void treatJsonPath(RegistroProducaoEntity entity, JsonPatch jsonPatch) {
		if (!JsonPatch.REMOVE_OPERATION.equals(jsonPatch.getOp())){
			return;
		}
		
		if("id".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setId(null);
		}
		if("peca".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setPeca(null);
		}
		if("funcionario".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setFuncionario(null);
		}
		if("maquina".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setMaquina(null);
		}
		if("dataInicio".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setDataInicio(null);
		}
		if("dataFinal".equals(jsonPatch.getPath().replace("/", ""))) {
			entity.setDataFinal(null);
		}
	}
}
