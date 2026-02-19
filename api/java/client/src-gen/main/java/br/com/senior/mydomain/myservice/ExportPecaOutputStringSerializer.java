package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportPecaOutputStringSerializer {
    
	public static final ExportPecaOutputStringSerializer INSTANCE = new ExportPecaOutputStringSerializer();
    
    public void serialize(ExportPecaOutput exportPecaOutput, StringBuilder sb, List<Object> appended) {
		sb.append(exportPecaOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportPecaOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportPecaOutput);
		serializeExportJobId(exportPecaOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeExportJobId(ExportPecaOutput exportPecaOutput, StringBuilder sb) {
		sb.append("exportJobId=").append(exportPecaOutput.exportJobId == null ? "null" : exportPecaOutput.exportJobId);
	}
}
