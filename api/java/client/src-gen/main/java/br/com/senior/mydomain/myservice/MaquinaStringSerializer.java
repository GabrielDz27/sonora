package br.com.senior.mydomain.myservice;

import java.util.List;

public class MaquinaStringSerializer {
    
	public static final MaquinaStringSerializer INSTANCE = new MaquinaStringSerializer();
    
    public void serialize(Maquina maquina, StringBuilder sb, List<Object> appended) {
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
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(Maquina maquina, StringBuilder sb) {
		sb.append("id=").append(maquina.id == null ? "null" : maquina.id);
	}
	
	protected void serializeNome(Maquina maquina, StringBuilder sb) {
		sb.append("nome=").append(maquina.nome == null ? "null" : maquina.nome);
	}
	
	protected void serializeStatus(Maquina maquina, StringBuilder sb) {
		sb.append("status=").append(maquina.status == null ? "null" : maquina.status);
	}
}
