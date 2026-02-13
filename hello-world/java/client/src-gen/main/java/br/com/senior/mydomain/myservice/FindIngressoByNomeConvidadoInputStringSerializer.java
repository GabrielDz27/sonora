package br.com.senior.mydomain.myservice;

import java.util.List;

public class FindIngressoByNomeConvidadoInputStringSerializer {
    
	public static final FindIngressoByNomeConvidadoInputStringSerializer INSTANCE = new FindIngressoByNomeConvidadoInputStringSerializer();
    
    public void serialize(FindIngressoByNomeConvidadoInput findIngressoByNomeConvidadoInput, StringBuilder sb, List<Object> appended) {
		sb.append(findIngressoByNomeConvidadoInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(findIngressoByNomeConvidadoInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(findIngressoByNomeConvidadoInput);
		serializeNomeConvidado(findIngressoByNomeConvidadoInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeNomeConvidado(FindIngressoByNomeConvidadoInput findIngressoByNomeConvidadoInput, StringBuilder sb) {
		sb.append("nomeConvidado=").append(findIngressoByNomeConvidadoInput.nomeConvidado == null ? "null" : findIngressoByNomeConvidadoInput.nomeConvidado);
	}
}
