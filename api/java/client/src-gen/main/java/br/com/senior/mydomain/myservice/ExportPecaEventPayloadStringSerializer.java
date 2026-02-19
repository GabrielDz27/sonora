package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportPecaEventPayloadStringSerializer {
    
	public static final ExportPecaEventPayloadStringSerializer INSTANCE = new ExportPecaEventPayloadStringSerializer();
    
    public void serialize(ExportPecaEventPayload exportPecaEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(exportPecaEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportPecaEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportPecaEventPayload);
		serializeEventpl(exportPecaEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ExportPecaEventPayload exportPecaEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (exportPecaEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			exportPecaEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
