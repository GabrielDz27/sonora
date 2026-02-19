package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportMaquinaOutputStringSerializer {
    
	public static final ImportMaquinaOutputStringSerializer INSTANCE = new ImportMaquinaOutputStringSerializer();
    
    public void serialize(ImportMaquinaOutput importMaquinaOutput, StringBuilder sb, List<Object> appended) {
		sb.append(importMaquinaOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importMaquinaOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importMaquinaOutput);
		serializeImportJobId(importMaquinaOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeImportJobId(ImportMaquinaOutput importMaquinaOutput, StringBuilder sb) {
		sb.append("importJobId=").append(importMaquinaOutput.importJobId == null ? "null" : importMaquinaOutput.importJobId);
	}
}
