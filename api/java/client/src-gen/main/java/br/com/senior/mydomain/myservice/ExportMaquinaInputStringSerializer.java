package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportMaquinaInputStringSerializer {
    
	public static final ExportMaquinaInputStringSerializer INSTANCE = new ExportMaquinaInputStringSerializer();
    
    public void serialize(ExportMaquinaInput exportMaquinaInput, StringBuilder sb, List<Object> appended) {
		sb.append(exportMaquinaInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportMaquinaInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportMaquinaInput);
		serializeConfig(exportMaquinaInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ExportMaquinaInput exportMaquinaInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (exportMaquinaInput.config == null) {
			sb.append("null");
		} else {
			exportMaquinaInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
