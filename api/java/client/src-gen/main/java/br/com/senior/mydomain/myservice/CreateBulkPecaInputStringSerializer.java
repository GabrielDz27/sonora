package br.com.senior.mydomain.myservice;

import java.util.List;

public class CreateBulkPecaInputStringSerializer {
    
	public static final CreateBulkPecaInputStringSerializer INSTANCE = new CreateBulkPecaInputStringSerializer();
    
    public void serialize(CreateBulkPecaInput createBulkPecaInput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkPecaInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkPecaInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkPecaInput);
		serializeEntities(createBulkPecaInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEntities(CreateBulkPecaInput createBulkPecaInput, StringBuilder sb) {
		sb.append("entities=").append(createBulkPecaInput.entities == null ? "null" : createBulkPecaInput.entities);
	}
}
