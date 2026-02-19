package br.com.senior.mydomain.myservice;

import java.util.List;

public class CreateBulkRegistroProducaoOutputStringSerializer {
    
	public static final CreateBulkRegistroProducaoOutputStringSerializer INSTANCE = new CreateBulkRegistroProducaoOutputStringSerializer();
    
    public void serialize(CreateBulkRegistroProducaoOutput createBulkRegistroProducaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkRegistroProducaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkRegistroProducaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkRegistroProducaoOutput);
		sb.append(']');
	}
	
}
