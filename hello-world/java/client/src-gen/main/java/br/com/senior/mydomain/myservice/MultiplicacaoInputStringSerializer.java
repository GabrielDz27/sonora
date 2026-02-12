package br.com.senior.mydomain.myservice;

import java.util.List;

public class MultiplicacaoInputStringSerializer {
    
	public static final MultiplicacaoInputStringSerializer INSTANCE = new MultiplicacaoInputStringSerializer();
    
    public void serialize(MultiplicacaoInput multiplicacaoInput, StringBuilder sb, List<Object> appended) {
		sb.append(multiplicacaoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(multiplicacaoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(multiplicacaoInput);
		serializeNumero1(multiplicacaoInput, sb);
		sb.append(", ");
		serializeNumero2(multiplicacaoInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeNumero1(MultiplicacaoInput multiplicacaoInput, StringBuilder sb) {
		sb.append("numero1=").append(multiplicacaoInput.numero1 == null ? "null" : multiplicacaoInput.numero1);
	}
	
	protected void serializeNumero2(MultiplicacaoInput multiplicacaoInput, StringBuilder sb) {
		sb.append("numero2=").append(multiplicacaoInput.numero2 == null ? "null" : multiplicacaoInput.numero2);
	}
}
