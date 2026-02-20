package br.com.senior.mydomain.myservice;

import java.util.List;

public class GetPecaInputStringSerializer {
    
	public static final GetPecaInputStringSerializer INSTANCE = new GetPecaInputStringSerializer();
    
    public void serialize(GetPecaInput getPecaInput, StringBuilder sb, List<Object> appended) {
		sb.append(getPecaInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(getPecaInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(getPecaInput);
		serializeStatus(getPecaInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeStatus(GetPecaInput getPecaInput, StringBuilder sb) {
		sb.append("status=").append(getPecaInput.status == null ? "null" : getPecaInput.status);
	}
}
