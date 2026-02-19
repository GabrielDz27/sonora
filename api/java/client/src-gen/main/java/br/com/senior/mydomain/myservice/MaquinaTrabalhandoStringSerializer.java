package br.com.senior.mydomain.myservice;

import java.util.List;

public class MaquinaTrabalhandoStringSerializer {
    
	public static final MaquinaTrabalhandoStringSerializer INSTANCE = new MaquinaTrabalhandoStringSerializer();
    
    public void serialize(MaquinaTrabalhando maquinaTrabalhando, StringBuilder sb, List<Object> appended) {
		sb.append(maquinaTrabalhando.getClass().getSimpleName()).append(" [");
		if (appended.contains(maquinaTrabalhando)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(maquinaTrabalhando);
		serializeMaquina(maquinaTrabalhando, sb, appended);
		sb.append(", ");
		serializeHoras(maquinaTrabalhando, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeMaquina(MaquinaTrabalhando maquinaTrabalhando, StringBuilder sb, List<Object> appended) {
		sb.append("maquina=<");
		if (maquinaTrabalhando.maquina == null) {
			sb.append("null");
		} else {
			maquinaTrabalhando.maquina.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeHoras(MaquinaTrabalhando maquinaTrabalhando, StringBuilder sb) {
		sb.append("horas=").append(maquinaTrabalhando.horas == null ? "null" : maquinaTrabalhando.horas);
	}
}
