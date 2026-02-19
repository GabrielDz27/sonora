/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.List;

public class MaquinaEntityStringSerializer {
	
	public static final MaquinaEntityStringSerializer INSTANCE = new MaquinaEntityStringSerializer();
    
    public void serialize(MaquinaEntity maquina, StringBuilder sb, List<Object> appended) {
		sb.append(maquina.getClass().getSimpleName()).append(" [");
		if (appended.contains(maquina)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(maquina);
		serializeId(maquina, sb);
		sb.append(", ");
		serializeNome(maquina, sb);
		sb.append(", ");
		serializeStatus(maquina, sb);
		sb.append(", ").append(", ");
		sb.append(']');
	}
	
	protected void serializeId(MaquinaEntity maquina, StringBuilder sb) {
		sb.append("id=").append(maquina.getId() == null ? "null" : maquina.getId());
	}
	
	protected void serializeNome(MaquinaEntity maquina, StringBuilder sb) {
		sb.append("nome=").append(maquina.getNome() == null ? "null" : maquina.getNome());
	}
	
	protected void serializeStatus(MaquinaEntity maquina, StringBuilder sb) {
		sb.append("status=").append(maquina.getStatus() == null ? "null" : maquina.getStatus());
	}
}
