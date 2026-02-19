package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportMaquinaInputStringSerializer {
    
	public static final ImportMaquinaInputStringSerializer INSTANCE = new ImportMaquinaInputStringSerializer();
    
    public void serialize(ImportMaquinaInput importMaquinaInput, StringBuilder sb, List<Object> appended) {
		sb.append(importMaquinaInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importMaquinaInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importMaquinaInput);
		serializeConfig(importMaquinaInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ImportMaquinaInput importMaquinaInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (importMaquinaInput.config == null) {
			sb.append("null");
		} else {
			importMaquinaInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
