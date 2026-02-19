package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportRegistroProducaoEventPayloadStringSerializer {
    
	public static final ImportRegistroProducaoEventPayloadStringSerializer INSTANCE = new ImportRegistroProducaoEventPayloadStringSerializer();
    
    public void serialize(ImportRegistroProducaoEventPayload importRegistroProducaoEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(importRegistroProducaoEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(importRegistroProducaoEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importRegistroProducaoEventPayload);
		serializeEventpl(importRegistroProducaoEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ImportRegistroProducaoEventPayload importRegistroProducaoEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (importRegistroProducaoEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			importRegistroProducaoEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
