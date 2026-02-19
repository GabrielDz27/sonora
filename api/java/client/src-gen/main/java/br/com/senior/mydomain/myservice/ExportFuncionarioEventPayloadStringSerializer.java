package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportFuncionarioEventPayloadStringSerializer {
    
	public static final ExportFuncionarioEventPayloadStringSerializer INSTANCE = new ExportFuncionarioEventPayloadStringSerializer();
    
    public void serialize(ExportFuncionarioEventPayload exportFuncionarioEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append(exportFuncionarioEventPayload.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportFuncionarioEventPayload)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportFuncionarioEventPayload);
		serializeEventpl(exportFuncionarioEventPayload, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeEventpl(ExportFuncionarioEventPayload exportFuncionarioEventPayload, StringBuilder sb, List<Object> appended) {
		sb.append("eventpl=<");
		if (exportFuncionarioEventPayload.eventpl == null) {
			sb.append("null");
		} else {
			exportFuncionarioEventPayload.eventpl.toString(sb, appended);
		}
		sb.append('>');
	}
}
