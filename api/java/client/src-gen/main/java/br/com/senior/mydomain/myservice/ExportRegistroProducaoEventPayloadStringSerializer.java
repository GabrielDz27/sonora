package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportRegistroProducaoEventPayloadStringSerializer {
    
	public static final ExportRegistroProducaoEventPayloadStringSerializer INSTANCE = new ExportRegistroProducaoEventPayloadStringSerializer();
    
    public void serialize(ExportRegistroProducaoEventPayload exportRegistroProducaoEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(exportRegistroProducaoEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportRegistroProducaoEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportRegistroProducaoEventPayload);
		serializeEventpl(exportRegistroProducaoEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ExportRegistroProducaoEventPayload exportRegistroProducaoEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (exportRegistroProducaoEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			exportRegistroProducaoEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
