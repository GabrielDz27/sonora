package br.com.senior.mydomain.myservice;

import java.util.List;

public class MultiplicacaoOutputStringSerializer {
    
	public static final MultiplicacaoOutputStringSerializer INSTANCE = new MultiplicacaoOutputStringSerializer();
    
    public void serialize(MultiplicacaoOutput multiplicacaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(multiplicacaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(multiplicacaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(multiplicacaoOutput);
		serializeResultado(multiplicacaoOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeResultado(MultiplicacaoOutput multiplicacaoOutput, StringBuilder sb) {
		sb.append("resultado=").append(multiplicacaoOutput.resultado == null ? "null" : multiplicacaoOutput.resultado);
	}
}
