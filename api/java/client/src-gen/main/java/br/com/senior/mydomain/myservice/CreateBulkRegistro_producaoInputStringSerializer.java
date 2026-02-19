package br.com.senior.mydomain.myservice;

import java.util.List;

public class CreateBulkRegistro_producaoInputStringSerializer {
    
	public static final CreateBulkRegistro_producaoInputStringSerializer INSTANCE = new CreateBulkRegistro_producaoInputStringSerializer();
    
    public void serialize(CreateBulkRegistro_producaoInput createBulkRegistro_producaoInput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkRegistro_producaoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkRegistro_producaoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkRegistro_producaoInput);
		serializeEntities(createBulkRegistro_producaoInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEntities(CreateBulkRegistro_producaoInput createBulkRegistro_producaoInput, StringBuilder sb) {
		sb.append("entities=").append(createBulkRegistro_producaoInput.entities == null ? "null" : createBulkRegistro_producaoInput.entities);
	}
}
