package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportMaquinaOutputStringSerializer {
    
	public static final ExportMaquinaOutputStringSerializer INSTANCE = new ExportMaquinaOutputStringSerializer();
    
    public void serialize(ExportMaquinaOutput exportMaquinaOutput, StringBuilder sb, List<Object> appended) {
		sb.append(exportMaquinaOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportMaquinaOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportMaquinaOutput);
		serializeExportJobId(exportMaquinaOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeExportJobId(ExportMaquinaOutput exportMaquinaOutput, StringBuilder sb) {
		sb.append("exportJobId=").append(exportMaquinaOutput.exportJobId == null ? "null" : exportMaquinaOutput.exportJobId);
	}
}
