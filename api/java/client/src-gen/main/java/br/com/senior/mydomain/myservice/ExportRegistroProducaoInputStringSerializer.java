package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportRegistroProducaoInputStringSerializer {
    
	public static final ExportRegistroProducaoInputStringSerializer INSTANCE = new ExportRegistroProducaoInputStringSerializer();
    
    public void serialize(ExportRegistroProducaoInput exportRegistroProducaoInput, StringBuilder sb, List<Object> appended) {
		sb.append(exportRegistroProducaoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportRegistroProducaoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportRegistroProducaoInput);
		serializeConfig(exportRegistroProducaoInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ExportRegistroProducaoInput exportRegistroProducaoInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (exportRegistroProducaoInput.config == null) {
			sb.append("null");
		} else {
			exportRegistroProducaoInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
