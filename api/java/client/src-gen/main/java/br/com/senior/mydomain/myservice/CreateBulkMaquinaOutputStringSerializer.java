package br.com.senior.mydomain.myservice;

import java.util.List;

public class CreateBulkMaquinaOutputStringSerializer {
    
	public static final CreateBulkMaquinaOutputStringSerializer INSTANCE = new CreateBulkMaquinaOutputStringSerializer();
    
    public void serialize(CreateBulkMaquinaOutput createBulkMaquinaOutput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkMaquinaOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkMaquinaOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkMaquinaOutput);
		sb.append(']');
	}
	
}
