package br.com.senior.mydomain.myservice;

import java.util.List;

public class DivisaoInputStringSerializer {
    
	public static final DivisaoInputStringSerializer INSTANCE = new DivisaoInputStringSerializer();
    
    public void serialize(DivisaoInput divisaoInput, StringBuilder sb, List<Object> appended) {
		sb.append(divisaoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(divisaoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(divisaoInput);
		serializeNumero1(divisaoInput, sb);
		sb.append(", ");
		serializeNumero2(divisaoInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeNumero1(DivisaoInput divisaoInput, StringBuilder sb) {
		sb.append("numero1=").append(divisaoInput.numero1 == null ? "null" : divisaoInput.numero1);
	}
	
	protected void serializeNumero2(DivisaoInput divisaoInput, StringBuilder sb) {
		sb.append("numero2=").append(divisaoInput.numero2 == null ? "null" : divisaoInput.numero2);
	}
}
