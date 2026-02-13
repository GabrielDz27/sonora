package br.com.senior.mydomain.myservice;

import java.util.List;

public class FindIngressoByNomeConvidadoOutputStringSerializer {
    
	public static final FindIngressoByNomeConvidadoOutputStringSerializer INSTANCE = new FindIngressoByNomeConvidadoOutputStringSerializer();
    
    public void serialize(FindIngressoByNomeConvidadoOutput findIngressoByNomeConvidadoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(findIngressoByNomeConvidadoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(findIngressoByNomeConvidadoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(findIngressoByNomeConvidadoOutput);
		serializeResultado(findIngressoByNomeConvidadoOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeResultado(FindIngressoByNomeConvidadoOutput findIngressoByNomeConvidadoOutput, StringBuilder sb, List<Object> appended) {
		sb.append("resultado=<");
		if (findIngressoByNomeConvidadoOutput.resultado == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = findIngressoByNomeConvidadoOutput.resultado.size() - 1;
			for (int i = 0; i <= last; i++) {
				findIngressoByNomeConvidadoOutput.resultado.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
}
