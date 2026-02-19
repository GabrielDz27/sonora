package br.com.senior.mydomain.myservice;

import java.util.List;

public class CreateBulkRegistro_producaoOutputStringSerializer {
    
	public static final CreateBulkRegistro_producaoOutputStringSerializer INSTANCE = new CreateBulkRegistro_producaoOutputStringSerializer();
    
    public void serialize(CreateBulkRegistro_producaoOutput createBulkRegistro_producaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkRegistro_producaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkRegistro_producaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkRegistro_producaoOutput);
		sb.append(']');
	}
	
}
