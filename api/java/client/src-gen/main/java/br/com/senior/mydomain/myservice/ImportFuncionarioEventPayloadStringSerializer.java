package br.com.senior.mydomain.myservice;

import java.util.List;

public class ImportFuncionarioEventPayloadStringSerializer {
    
	public static final ImportFuncionarioEventPayloadStringSerializer INSTANCE = new ImportFuncionarioEventPayloadStringSerializer();
    
    public void serialize(ImportFuncionarioEventPayload importFuncionarioEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(importFuncionarioEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(importFuncionarioEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(importFuncionarioEventPayload);
		serializeEventpl(importFuncionarioEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ImportFuncionarioEventPayload importFuncionarioEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (importFuncionarioEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			importFuncionarioEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
