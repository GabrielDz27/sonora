package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportRegistroProducaoInputStringSerializer {
    
	public static final ImportRegistroProducaoInputStringSerializer INSTANCE = new ImportRegistroProducaoInputStringSerializer();
    
    public void serialize(ImportRegistroProducaoInput importRegistroProducaoInput, StringBuilder sb, List<Object> appended) {
		sb.append(importRegistroProducaoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importRegistroProducaoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importRegistroProducaoInput);
		serializeConfig(importRegistroProducaoInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ImportRegistroProducaoInput importRegistroProducaoInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (importRegistroProducaoInput.config == null) {
			sb.append("null");
		} else {
			importRegistroProducaoInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
