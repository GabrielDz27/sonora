package br.com.senior.mydomain.myservice;

import java.util.List;

public class FinalizarInputStringSerializer {
    
	public static final FinalizarInputStringSerializer INSTANCE = new FinalizarInputStringSerializer();
    
    public void serialize(FinalizarInput finalizarInput, StringBuilder sb, List<Object> appended) {
		sb.append(finalizarInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(finalizarInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(finalizarInput);
		serializeId(finalizarInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(FinalizarInput finalizarInput, StringBuilder sb) {
		sb.append("id=").append(finalizarInput.id == null ? "null" : finalizarInput.id);
	}
}
