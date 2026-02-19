package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportRegistroProducaoOutputStringSerializer {
    
	public static final ExportRegistroProducaoOutputStringSerializer INSTANCE = new ExportRegistroProducaoOutputStringSerializer();
    
    public void serialize(ExportRegistroProducaoOutput exportRegistroProducaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(exportRegistroProducaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportRegistroProducaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportRegistroProducaoOutput);
		serializeExportJobId(exportRegistroProducaoOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeExportJobId(ExportRegistroProducaoOutput exportRegistroProducaoOutput, StringBuilder sb) {
		sb.append("exportJobId=").append(exportRegistroProducaoOutput.exportJobId == null ? "null" : exportRegistroProducaoOutput.exportJobId);
	}
}
