package br.com.senior.mydomain.myservice;

import java.util.List;

public class CreateBulkFuncionarioOutputStringSerializer {
    
	public static final CreateBulkFuncionarioOutputStringSerializer INSTANCE = new CreateBulkFuncionarioOutputStringSerializer();
    
    public void serialize(CreateBulkFuncionarioOutput createBulkFuncionarioOutput, StringBuilder sb, List<Object> appended) {
		sb.append(createBulkFuncionarioOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(createBulkFuncionarioOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(createBulkFuncionarioOutput);
		sb.append(']');
	}
	
}
