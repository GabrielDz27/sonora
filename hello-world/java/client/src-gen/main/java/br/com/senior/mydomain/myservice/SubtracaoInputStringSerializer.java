package br.com.senior.mydomain.myservice;

import java.util.List;

public class SubtracaoInputStringSerializer {
    
	public static final SubtracaoInputStringSerializer INSTANCE = new SubtracaoInputStringSerializer();
    
    public void serialize(SubtracaoInput subtracaoInput, StringBuilder sb, List<Object> appended) {
		sb.append(subtracaoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(subtracaoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(subtracaoInput);
		serializeNumero1(subtracaoInput, sb);
		sb.append(", ");
		serializeNumero2(subtracaoInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeNumero1(SubtracaoInput subtracaoInput, StringBuilder sb) {
		sb.append("numero1=").append(subtracaoInput.numero1 == null ? "null" : subtracaoInput.numero1);
	}
	
	protected void serializeNumero2(SubtracaoInput subtracaoInput, StringBuilder sb) {
		sb.append("numero2=").append(subtracaoInput.numero2 == null ? "null" : subtracaoInput.numero2);
	}
}
