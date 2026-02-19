package br.com.senior.mydomain.myservice;

import java.util.List;

public class MudarStatusPecaInputStringSerializer {
    
	public static final MudarStatusPecaInputStringSerializer INSTANCE = new MudarStatusPecaInputStringSerializer();
    
    public void serialize(MudarStatusPecaInput mudarStatusPecaInput, StringBuilder sb, List<Object> appended) {
		sb.append(mudarStatusPecaInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(mudarStatusPecaInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(mudarStatusPecaInput);
		serializeId(mudarStatusPecaInput, sb);
		sb.append(", ");
		serializeStatus(mudarStatusPecaInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(MudarStatusPecaInput mudarStatusPecaInput, StringBuilder sb) {
		sb.append("id=").append(mudarStatusPecaInput.id == null ? "null" : mudarStatusPecaInput.id);
	}
	
	protected void serializeStatus(MudarStatusPecaInput mudarStatusPecaInput, StringBuilder sb) {
		sb.append("status=").append(mudarStatusPecaInput.status == null ? "null" : mudarStatusPecaInput.status);
	}
}
