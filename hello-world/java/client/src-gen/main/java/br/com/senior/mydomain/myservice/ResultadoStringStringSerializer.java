package br.com.senior.mydomain.myservice;

import java.util.List;

public class ResultadoStringStringSerializer {
    
	public static final ResultadoStringStringSerializer INSTANCE = new ResultadoStringStringSerializer();
    
    public void serialize(ResultadoString resultadoString, StringBuilder sb, List<Object> appended) {
		sb.append(resultadoString.getClass().getSimpleName()).append(" [");
		if (appended.contains(resultadoString)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(resultadoString);
		serializeResultado(resultadoString, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeResultado(ResultadoString resultadoString, StringBuilder sb) {
		sb.append("resultado=").append(resultadoString.resultado == null ? "null" : resultadoString.resultado);
	}
}
