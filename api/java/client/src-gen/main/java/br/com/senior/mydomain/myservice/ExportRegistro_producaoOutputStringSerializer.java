package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportRegistro_producaoOutputStringSerializer {
    
	public static final ExportRegistro_producaoOutputStringSerializer INSTANCE = new ExportRegistro_producaoOutputStringSerializer();
    
    public void serialize(ExportRegistro_producaoOutput exportRegistro_producaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(exportRegistro_producaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportRegistro_producaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportRegistro_producaoOutput);
		serializeExportJobId(exportRegistro_producaoOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeExportJobId(ExportRegistro_producaoOutput exportRegistro_producaoOutput, StringBuilder sb) {
		sb.append("exportJobId=").append(exportRegistro_producaoOutput.exportJobId == null ? "null" : exportRegistro_producaoOutput.exportJobId);
	}
}
