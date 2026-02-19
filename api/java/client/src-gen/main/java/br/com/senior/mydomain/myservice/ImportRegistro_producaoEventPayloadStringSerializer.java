package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportRegistro_producaoEventPayloadStringSerializer {
    
	public static final ImportRegistro_producaoEventPayloadStringSerializer INSTANCE = new ImportRegistro_producaoEventPayloadStringSerializer();
    
    public void serialize(ImportRegistro_producaoEventPayload importRegistro_producaoEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(importRegistro_producaoEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(importRegistro_producaoEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importRegistro_producaoEventPayload);
		serializeEventpl(importRegistro_producaoEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ImportRegistro_producaoEventPayload importRegistro_producaoEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (importRegistro_producaoEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			importRegistro_producaoEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
