package br.com.senior.mydomain.myservice;

import java.util.List;

public class FindByNomeInputStringSerializer {
    
	public static final FindByNomeInputStringSerializer INSTANCE = new FindByNomeInputStringSerializer();
    
    public void serialize(FindByNomeInput findByNomeInput, StringBuilder sb, List<Object> appended) {
		sb.append(findByNomeInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(findByNomeInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(findByNomeInput);
		serializeNome(findByNomeInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeNome(FindByNomeInput findByNomeInput, StringBuilder sb) {
		sb.append("nome=").append(findByNomeInput.nome == null ? "null" : findByNomeInput.nome);
	}
}
