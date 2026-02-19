package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportPecaEventPayloadStringSerializer {
    
	public static final ImportPecaEventPayloadStringSerializer INSTANCE = new ImportPecaEventPayloadStringSerializer();
    
    public void serialize(ImportPecaEventPayload importPecaEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(importPecaEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(importPecaEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importPecaEventPayload);
		serializeEventpl(importPecaEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ImportPecaEventPayload importPecaEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (importPecaEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			importPecaEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
