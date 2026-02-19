/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.List;

public class PecaEntityStringSerializer {
	
	public static final PecaEntityStringSerializer INSTANCE = new PecaEntityStringSerializer();
    
    public void serialize(PecaEntity peca, StringBuilder sb, List<Object> appended) {
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
		sb.append(", ").append(", ");
		sb.append(']');
	}
	
	protected void serializeId(PecaEntity peca, StringBuilder sb) {
		sb.append("id=").append(peca.getId() == null ? "null" : peca.getId());
	}
	
	protected void serializeNome(PecaEntity peca, StringBuilder sb) {
		sb.append("nome=").append(peca.getNome() == null ? "null" : peca.getNome());
	}
	
	protected void serializeCodigoDesenho(PecaEntity peca, StringBuilder sb) {
		sb.append("codigoDesenho=").append(peca.getCodigoDesenho() == null ? "null" : peca.getCodigoDesenho());
	}
	
	protected void serializeTempoEstimadoMinutos(PecaEntity peca, StringBuilder sb) {
		sb.append("tempoEstimadoMinutos=").append(peca.getTempoEstimadoMinutos() == null ? "null" : peca.getTempoEstimadoMinutos());
	}
	
	protected void serializeStatus(PecaEntity peca, StringBuilder sb) {
		sb.append("status=").append(peca.getStatus() == null ? "null" : peca.getStatus());
	}
}
