package br.com.senior.mydomain.myservice;

import java.util.List;

public class DivisaoOutputStringSerializer {
    
	public static final DivisaoOutputStringSerializer INSTANCE = new DivisaoOutputStringSerializer();
    
    public void serialize(DivisaoOutput divisaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(divisaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(divisaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(divisaoOutput);
		serializeResultado(divisaoOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeResultado(DivisaoOutput divisaoOutput, StringBuilder sb) {
		sb.append("resultado=").append(divisaoOutput.resultado == null ? "null" : divisaoOutput.resultado);
	}
}
