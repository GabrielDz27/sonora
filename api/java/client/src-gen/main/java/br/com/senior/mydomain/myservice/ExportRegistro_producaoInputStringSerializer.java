package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportRegistro_producaoInputStringSerializer {
    
	public static final ExportRegistro_producaoInputStringSerializer INSTANCE = new ExportRegistro_producaoInputStringSerializer();
    
    public void serialize(ExportRegistro_producaoInput exportRegistro_producaoInput, StringBuilder sb, List<Object> appended) {
		sb.append(exportRegistro_producaoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportRegistro_producaoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportRegistro_producaoInput);
		serializeConfig(exportRegistro_producaoInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ExportRegistro_producaoInput exportRegistro_producaoInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (exportRegistro_producaoInput.config == null) {
			sb.append("null");
		} else {
			exportRegistro_producaoInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
