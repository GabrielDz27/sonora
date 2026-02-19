package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportRegistro_producaoEventPayloadStringSerializer {
    
	public static final ExportRegistro_producaoEventPayloadStringSerializer INSTANCE = new ExportRegistro_producaoEventPayloadStringSerializer();
    
    public void serialize(ExportRegistro_producaoEventPayload exportRegistro_producaoEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(exportRegistro_producaoEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportRegistro_producaoEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportRegistro_producaoEventPayload);
		serializeEventpl(exportRegistro_producaoEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ExportRegistro_producaoEventPayload exportRegistro_producaoEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (exportRegistro_producaoEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			exportRegistro_producaoEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
