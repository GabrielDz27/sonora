package br.com.senior.mydomain.myservice;

import java.util.List;

public class SubtracaoOutputStringSerializer {
    
	public static final SubtracaoOutputStringSerializer INSTANCE = new SubtracaoOutputStringSerializer();
    
    public void serialize(SubtracaoOutput subtracaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(subtracaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(subtracaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(subtracaoOutput);
		serializeResultado(subtracaoOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeResultado(SubtracaoOutput subtracaoOutput, StringBuilder sb) {
		sb.append("resultado=").append(subtracaoOutput.resultado == null ? "null" : subtracaoOutput.resultado);
	}
}
