package br.com.senior.mydomain.myservice;

import java.util.List;

public class FindByNomeOutputStringSerializer {
    
	public static final FindByNomeOutputStringSerializer INSTANCE = new FindByNomeOutputStringSerializer();
    
    public void serialize(FindByNomeOutput findByNomeOutput, StringBuilder sb, List<Object> appended) {
		sb.append(findByNomeOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(findByNomeOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(findByNomeOutput);
		serializeResultado(findByNomeOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeResultado(FindByNomeOutput findByNomeOutput, StringBuilder sb, List<Object> appended) {
		sb.append("resultado=<");
		if (findByNomeOutput.resultado == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = findByNomeOutput.resultado.size() - 1;
			for (int i = 0; i <= last; i++) {
				findByNomeOutput.resultado.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
}
