package br.com.senior.mydomain.myservice;

import java.util.List;

public class RelatorioOutputStringSerializer {
    
	public static final RelatorioOutputStringSerializer INSTANCE = new RelatorioOutputStringSerializer();
    
    public void serialize(RelatorioOutput relatorioOutput, StringBuilder sb, List<Object> appended) {
		sb.append(relatorioOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(relatorioOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(relatorioOutput);
		serializeRetorno(relatorioOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeRetorno(RelatorioOutput relatorioOutput, StringBuilder sb, List<Object> appended) {
		sb.append("retorno=<");
		if (relatorioOutput.retorno == null) {
			sb.append("null");
		} else {
			relatorioOutput.retorno.toString(sb, appended);
		}
		sb.append('>');
	}
}
