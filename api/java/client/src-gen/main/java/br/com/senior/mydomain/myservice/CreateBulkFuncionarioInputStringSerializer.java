package br.com.senior.mydomain.myservice;

import java.util.List;

public class CreateBulkFuncionarioInputStringSerializer {
    
	public static final CreateBulkFuncionarioInputStringSerializer INSTANCE = new CreateBulkFuncionarioInputStringSerializer();
    
    public void serialize(CreateBulkFuncionarioInput createBulkFuncionarioInput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkFuncionarioInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkFuncionarioInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkFuncionarioInput);
		serializeEntities(createBulkFuncionarioInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEntities(CreateBulkFuncionarioInput createBulkFuncionarioInput, StringBuilder sb) {
		sb.append("entities=").append(createBulkFuncionarioInput.entities == null ? "null" : createBulkFuncionarioInput.entities);
	}
}
