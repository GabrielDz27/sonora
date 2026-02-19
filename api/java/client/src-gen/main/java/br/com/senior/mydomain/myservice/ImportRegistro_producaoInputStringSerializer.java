package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportRegistro_producaoInputStringSerializer {
    
	public static final ImportRegistro_producaoInputStringSerializer INSTANCE = new ImportRegistro_producaoInputStringSerializer();
    
    public void serialize(ImportRegistro_producaoInput importRegistro_producaoInput, StringBuilder sb, List<Object> appended) {
		sb.append(importRegistro_producaoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importRegistro_producaoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importRegistro_producaoInput);
		serializeConfig(importRegistro_producaoInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ImportRegistro_producaoInput importRegistro_producaoInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (importRegistro_producaoInput.config == null) {
			sb.append("null");
		} else {
			importRegistro_producaoInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
