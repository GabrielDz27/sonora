package br.com.senior.mydomain.myservice;

import java.util.List;

public class CreateBulkPecaOutputStringSerializer {
    
	public static final CreateBulkPecaOutputStringSerializer INSTANCE = new CreateBulkPecaOutputStringSerializer();
    
    public void serialize(CreateBulkPecaOutput createBulkPecaOutput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkPecaOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkPecaOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkPecaOutput);
		sb.append(']');
	}
	
}
