package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportPecaInputStringSerializer {
    
	public static final ExportPecaInputStringSerializer INSTANCE = new ExportPecaInputStringSerializer();
    
    public void serialize(ExportPecaInput exportPecaInput, StringBuilder sb, List<Object> appended) {
		sb.append(exportPecaInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportPecaInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportPecaInput);
		serializeConfig(exportPecaInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ExportPecaInput exportPecaInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (exportPecaInput.config == null) {
			sb.append("null");
		} else {
			exportPecaInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
