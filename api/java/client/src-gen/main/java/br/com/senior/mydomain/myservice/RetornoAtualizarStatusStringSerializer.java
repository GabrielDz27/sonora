package br.com.senior.mydomain.myservice;

import java.util.List;

public class RetornoAtualizarStatusStringSerializer {
    
	public static final RetornoAtualizarStatusStringSerializer INSTANCE = new RetornoAtualizarStatusStringSerializer();
    
    public void serialize(RetornoAtualizarStatus retornoAtualizarStatus, StringBuilder sb, List<Object> appended) {
		sb.append(retornoAtualizarStatus.getClass().getSimpleName()).append(" [");
		if (appended.contains(retornoAtualizarStatus)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(retornoAtualizarStatus);
		serializeMensagemRetorno(retornoAtualizarStatus, sb);
		sb.append(", ");
		serializeId(retornoAtualizarStatus, sb);
		sb.append(", ");
		serializeContemErro(retornoAtualizarStatus, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeMensagemRetorno(RetornoAtualizarStatus retornoAtualizarStatus, StringBuilder sb) {
		sb.append("mensagemRetorno=").append(retornoAtualizarStatus.mensagemRetorno == null ? "null" : retornoAtualizarStatus.mensagemRetorno);
	}
	
	protected void serializeId(RetornoAtualizarStatus retornoAtualizarStatus, StringBuilder sb) {
		sb.append("id=").append(retornoAtualizarStatus.id == null ? "null" : retornoAtualizarStatus.id);
	}
	
	protected void serializeContemErro(RetornoAtualizarStatus retornoAtualizarStatus, StringBuilder sb) {
		sb.append("contemErro=").append(retornoAtualizarStatus.contemErro == null ? "null" : retornoAtualizarStatus.contemErro);
	}
}
