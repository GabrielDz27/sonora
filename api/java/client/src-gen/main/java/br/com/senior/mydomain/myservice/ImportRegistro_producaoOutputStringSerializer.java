package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportRegistro_producaoOutputStringSerializer {
    
	public static final ImportRegistro_producaoOutputStringSerializer INSTANCE = new ImportRegistro_producaoOutputStringSerializer();
    
    public void serialize(ImportRegistro_producaoOutput importRegistro_producaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(importRegistro_producaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importRegistro_producaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importRegistro_producaoOutput);
		serializeImportJobId(importRegistro_producaoOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeImportJobId(ImportRegistro_producaoOutput importRegistro_producaoOutput, StringBuilder sb) {
		sb.append("importJobId=").append(importRegistro_producaoOutput.importJobId == null ? "null" : importRegistro_producaoOutput.importJobId);
	}
}
