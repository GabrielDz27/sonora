package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportMaquinaEventPayloadStringSerializer {
    
	public static final ExportMaquinaEventPayloadStringSerializer INSTANCE = new ExportMaquinaEventPayloadStringSerializer();
    
    public void serialize(ExportMaquinaEventPayload exportMaquinaEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(exportMaquinaEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportMaquinaEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportMaquinaEventPayload);
		serializeEventpl(exportMaquinaEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ExportMaquinaEventPayload exportMaquinaEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (exportMaquinaEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			exportMaquinaEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
