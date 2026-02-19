package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportPecaOutputStringSerializer {
    
	public static final ImportPecaOutputStringSerializer INSTANCE = new ImportPecaOutputStringSerializer();
    
    public void serialize(ImportPecaOutput importPecaOutput, StringBuilder sb, List<Object> appended) {
		sb.append(importPecaOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(importPecaOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importPecaOutput);
		serializeImportJobId(importPecaOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeImportJobId(ImportPecaOutput importPecaOutput, StringBuilder sb) {
		sb.append("importJobId=").append(importPecaOutput.importJobId == null ? "null" : importPecaOutput.importJobId);
	}
}
