package br.com.senior.mydomain.myservice;

import java.util.List;

public class CreateBulkMaquinaInputStringSerializer {
    
	public static final CreateBulkMaquinaInputStringSerializer INSTANCE = new CreateBulkMaquinaInputStringSerializer();
    
    public void serialize(CreateBulkMaquinaInput createBulkMaquinaInput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkMaquinaInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkMaquinaInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkMaquinaInput);
		serializeEntities(createBulkMaquinaInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEntities(CreateBulkMaquinaInput createBulkMaquinaInput, StringBuilder sb) {
		sb.append("entities=").append(createBulkMaquinaInput.entities == null ? "null" : createBulkMaquinaInput.entities);
	}
}
