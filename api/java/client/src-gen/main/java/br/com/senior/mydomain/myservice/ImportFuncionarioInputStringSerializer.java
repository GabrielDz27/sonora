package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportFuncionarioInputStringSerializer {
    
	public static final ImportFuncionarioInputStringSerializer INSTANCE = new ImportFuncionarioInputStringSerializer();
    
    public void serialize(ImportFuncionarioInput importFuncionarioInput, StringBuilder sb, List<Object> appended) {
		sb.append(importFuncionarioInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importFuncionarioInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importFuncionarioInput);
		serializeConfig(importFuncionarioInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ImportFuncionarioInput importFuncionarioInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (importFuncionarioInput.config == null) {
			sb.append("null");
		} else {
			importFuncionarioInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
