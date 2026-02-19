package br.com.senior.mydomain.myservice;

import java.util.List;

public class ExportFuncionarioOutputStringSerializer {
    
	public static final ExportFuncionarioOutputStringSerializer INSTANCE = new ExportFuncionarioOutputStringSerializer();
    
    public void serialize(ExportFuncionarioOutput exportFuncionarioOutput, StringBuilder sb, List<Object> appended) {
		sb.append(exportFuncionarioOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(exportFuncionarioOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(exportFuncionarioOutput);
		serializeExportJobId(exportFuncionarioOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeExportJobId(ExportFuncionarioOutput exportFuncionarioOutput, StringBuilder sb) {
		sb.append("exportJobId=").append(exportFuncionarioOutput.exportJobId == null ? "null" : exportFuncionarioOutput.exportJobId);
	}
}
