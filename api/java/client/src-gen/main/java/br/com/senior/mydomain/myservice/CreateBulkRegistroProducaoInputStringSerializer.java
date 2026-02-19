package br.com.senior.mydomain.myservice;

import java.util.List;

public class CreateBulkRegistroProducaoInputStringSerializer {
    
	public static final CreateBulkRegistroProducaoInputStringSerializer INSTANCE = new CreateBulkRegistroProducaoInputStringSerializer();
    
    public void serialize(CreateBulkRegistroProducaoInput createBulkRegistroProducaoInput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkRegistroProducaoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkRegistroProducaoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkRegistroProducaoInput);
		serializeEntities(createBulkRegistroProducaoInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEntities(CreateBulkRegistroProducaoInput createBulkRegistroProducaoInput, StringBuilder sb) {
		sb.append("entities=").append(createBulkRegistroProducaoInput.entities == null ? "null" : createBulkRegistroProducaoInput.entities);
	}
}
