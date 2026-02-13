package br.com.senior.mydomain.myservice;

import java.util.List;

public class FindNomeByIdInputStringSerializer {
    
	public static final FindNomeByIdInputStringSerializer INSTANCE = new FindNomeByIdInputStringSerializer();
    
    public void serialize(FindNomeByIdInput findNomeByIdInput, StringBuilder sb, List<Object> appended) {
		sb.append(findNomeByIdInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(findNomeByIdInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(findNomeByIdInput);
		serializeId(findNomeByIdInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(FindNomeByIdInput findNomeByIdInput, StringBuilder sb) {
		sb.append("id=").append(findNomeByIdInput.id == null ? "null" : findNomeByIdInput.id);
	}
}
