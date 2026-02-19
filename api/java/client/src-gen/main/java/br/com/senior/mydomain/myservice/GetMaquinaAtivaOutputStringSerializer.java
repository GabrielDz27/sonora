package br.com.senior.mydomain.myservice;

import java.util.List;

public class GetMaquinaAtivaOutputStringSerializer {
    
	public static final GetMaquinaAtivaOutputStringSerializer INSTANCE = new GetMaquinaAtivaOutputStringSerializer();
    
    public void serialize(GetMaquinaAtivaOutput getMaquinaAtivaOutput, StringBuilder sb, List<Object> appended) {
		sb.append(getMaquinaAtivaOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(getMaquinaAtivaOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(getMaquinaAtivaOutput);
		serializeMaquina(getMaquinaAtivaOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeMaquina(GetMaquinaAtivaOutput getMaquinaAtivaOutput, StringBuilder sb, List<Object> appended) {
		sb.append("maquina=<");
		if (getMaquinaAtivaOutput.maquina == null) {
			sb.append("null");
		} else {
			getMaquinaAtivaOutput.maquina.toString(sb, appended);
		}
		sb.append('>');
	}
}
