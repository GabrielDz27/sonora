package br.com.senior.mydomain.myservice;

import java.util.List;

public class AdicaoInputStringSerializer {
    
	public static final AdicaoInputStringSerializer INSTANCE = new AdicaoInputStringSerializer();
    
    public void serialize(AdicaoInput adicaoInput, StringBuilder sb, List<Object> appended) {
		sb.append(adicaoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(adicaoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(adicaoInput);
		serializeNumero1(adicaoInput, sb);
		sb.append(", ");
		serializeNumero2(adicaoInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeNumero1(AdicaoInput adicaoInput, StringBuilder sb) {
		sb.append("numero1=").append(adicaoInput.numero1 == null ? "null" : adicaoInput.numero1);
	}
	
	protected void serializeNumero2(AdicaoInput adicaoInput, StringBuilder sb) {
		sb.append("numero2=").append(adicaoInput.numero2 == null ? "null" : adicaoInput.numero2);
	}
}
