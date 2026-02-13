package br.com.senior.mydomain.myservice;

import java.util.List;

public class FindNomeByIdOutputStringSerializer {
    
	public static final FindNomeByIdOutputStringSerializer INSTANCE = new FindNomeByIdOutputStringSerializer();
    
    public void serialize(FindNomeByIdOutput findNomeByIdOutput, StringBuilder sb, List<Object> appended) {
		sb.append(findNomeByIdOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(findNomeByIdOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(findNomeByIdOutput);
		serializeNome(findNomeByIdOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeNome(FindNomeByIdOutput findNomeByIdOutput, StringBuilder sb) {
		sb.append("nome=").append(findNomeByIdOutput.nome == null ? "null" : findNomeByIdOutput.nome);
	}
}
