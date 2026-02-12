package br.com.senior.mydomain.myservice;

import java.util.List;

public class AdicaoOutputStringSerializer {
    
	public static final AdicaoOutputStringSerializer INSTANCE = new AdicaoOutputStringSerializer();
    
    public void serialize(AdicaoOutput adicaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(adicaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(adicaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(adicaoOutput);
		serializeResultado(adicaoOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeResultado(AdicaoOutput adicaoOutput, StringBuilder sb) {
		sb.append("resultado=").append(adicaoOutput.resultado == null ? "null" : adicaoOutput.resultado);
	}
}
