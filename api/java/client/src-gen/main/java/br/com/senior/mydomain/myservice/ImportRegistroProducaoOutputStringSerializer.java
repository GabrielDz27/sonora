package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportRegistroProducaoOutputStringSerializer {
    
	public static final ImportRegistroProducaoOutputStringSerializer INSTANCE = new ImportRegistroProducaoOutputStringSerializer();
    
    public void serialize(ImportRegistroProducaoOutput importRegistroProducaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(importRegistroProducaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importRegistroProducaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importRegistroProducaoOutput);
		serializeImportJobId(importRegistroProducaoOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeImportJobId(ImportRegistroProducaoOutput importRegistroProducaoOutput, StringBuilder sb) {
		sb.append("importJobId=").append(importRegistroProducaoOutput.importJobId == null ? "null" : importRegistroProducaoOutput.importJobId);
	}
}
