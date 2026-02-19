package br.com.senior.mydomain.myservice;

import java.util.List;

public class MudarStatusPecaOutputStringSerializer {
    
	public static final MudarStatusPecaOutputStringSerializer INSTANCE = new MudarStatusPecaOutputStringSerializer();
    
    public void serialize(MudarStatusPecaOutput mudarStatusPecaOutput, StringBuilder sb, List<Object> appended) {
		sb.append(mudarStatusPecaOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(mudarStatusPecaOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(mudarStatusPecaOutput);
		serializeRetorno(mudarStatusPecaOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeRetorno(MudarStatusPecaOutput mudarStatusPecaOutput, StringBuilder sb, List<Object> appended) {
		sb.append("retorno=<");
		if (mudarStatusPecaOutput.retorno == null) {
			sb.append("null");
		} else {
			mudarStatusPecaOutput.retorno.toString(sb, appended);
		}
		sb.append('>');
	}
}
