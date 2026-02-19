package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportFuncionarioOutputStringSerializer {
    
	public static final ImportFuncionarioOutputStringSerializer INSTANCE = new ImportFuncionarioOutputStringSerializer();
    
    public void serialize(ImportFuncionarioOutput importFuncionarioOutput, StringBuilder sb, List<Object> appended) {
		sb.append(importFuncionarioOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importFuncionarioOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importFuncionarioOutput);
		serializeImportJobId(importFuncionarioOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeImportJobId(ImportFuncionarioOutput importFuncionarioOutput, StringBuilder sb) {
		sb.append("importJobId=").append(importFuncionarioOutput.importJobId == null ? "null" : importFuncionarioOutput.importJobId);
	}
}
