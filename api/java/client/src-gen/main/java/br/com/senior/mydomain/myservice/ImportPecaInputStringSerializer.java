package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportPecaInputStringSerializer {
    
	public static final ImportPecaInputStringSerializer INSTANCE = new ImportPecaInputStringSerializer();
    
    public void serialize(ImportPecaInput importPecaInput, StringBuilder sb, List<Object> appended) {
		sb.append(importPecaInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importPecaInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importPecaInput);
		serializeConfig(importPecaInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ImportPecaInput importPecaInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (importPecaInput.config == null) {
			sb.append("null");
		} else {
			importPecaInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
