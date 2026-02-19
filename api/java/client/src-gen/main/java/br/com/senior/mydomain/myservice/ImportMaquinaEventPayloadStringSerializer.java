package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportMaquinaEventPayloadStringSerializer {
    
	public static final ImportMaquinaEventPayloadStringSerializer INSTANCE = new ImportMaquinaEventPayloadStringSerializer();
    
    public void serialize(ImportMaquinaEventPayload importMaquinaEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(importMaquinaEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(importMaquinaEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importMaquinaEventPayload);
		serializeEventpl(importMaquinaEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ImportMaquinaEventPayload importMaquinaEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (importMaquinaEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			importMaquinaEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
