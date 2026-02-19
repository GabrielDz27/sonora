package br.com.senior.mydomain.myservice;

import java.util.List;

public class PecaStringSerializer {
    
	public static final PecaStringSerializer INSTANCE = new PecaStringSerializer();
    
    public void serialize(Peca peca, StringBuilder sb, List<Object> appended) {
		sb.append(peca.getClass().getSimpleName()).append(" [");
		if (appended.contains(peca)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(peca);
		serializeId(peca, sb);
		sb.append(", ");
		serializeNome(peca, sb);
		sb.append(", ");
		serializeCodigoDesenho(peca, sb);
		sb.append(", ");
		serializeTempoEstimadoMinutos(peca, sb);
		sb.append(", ");
		serializeStatus(peca, sb);
		sb.append(", ");
		serializeValor(peca, sb);
		sb.append(", ");
		serializeMotivoPerda(peca, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(Peca peca, StringBuilder sb) {
		sb.append("id=").append(peca.id == null ? "null" : peca.id);
	}
	
	protected void serializeNome(Peca peca, StringBuilder sb) {
		sb.append("nome=").append(peca.nome == null ? "null" : peca.nome);
	}
	
	protected void serializeCodigoDesenho(Peca peca, StringBuilder sb) {
		sb.append("codigoDesenho=").append(peca.codigoDesenho == null ? "null" : peca.codigoDesenho);
	}
	
	protected void serializeTempoEstimadoMinutos(Peca peca, StringBuilder sb) {
		sb.append("tempoEstimadoMinutos=").append(peca.tempoEstimadoMinutos == null ? "null" : peca.tempoEstimadoMinutos);
	}
	
	protected void serializeStatus(Peca peca, StringBuilder sb) {
		sb.append("status=").append(peca.status == null ? "null" : peca.status);
	}
	
	protected void serializeValor(Peca peca, StringBuilder sb) {
		sb.append("valor=").append(peca.valor == null ? "null" : peca.valor);
	}
	
	protected void serializeMotivoPerda(Peca peca, StringBuilder sb) {
		sb.append("motivoPerda=").append(peca.motivoPerda == null ? "null" : peca.motivoPerda);
	}
}
