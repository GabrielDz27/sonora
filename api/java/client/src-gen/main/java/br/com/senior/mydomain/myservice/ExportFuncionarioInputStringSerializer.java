package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportFuncionarioInputStringSerializer {
    
	public static final ExportFuncionarioInputStringSerializer INSTANCE = new ExportFuncionarioInputStringSerializer();
    
    public void serialize(ExportFuncionarioInput exportFuncionarioInput, StringBuilder sb, List<Object> appended) {
		sb.append(exportFuncionarioInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportFuncionarioInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportFuncionarioInput);
		serializeConfig(exportFuncionarioInput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeConfig(ExportFuncionarioInput exportFuncionarioInput, StringBuilder sb, List<Object> appended) {
		sb.append("config=<");
		if (exportFuncionarioInput.config == null) {
			sb.append("null");
		} else {
			exportFuncionarioInput.config.toString(sb, appended);
		}
		sb.append('>');
	}
}
