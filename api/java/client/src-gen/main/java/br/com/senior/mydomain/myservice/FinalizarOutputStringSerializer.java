package br.com.senior.mydomain.myservice;

import java.util.List;

public class FinalizarOutputStringSerializer {
    
	public static final FinalizarOutputStringSerializer INSTANCE = new FinalizarOutputStringSerializer();
    
    public void serialize(FinalizarOutput finalizarOutput, StringBuilder sb, List<Object> appended) {
		sb.append(finalizarOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(finalizarOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(finalizarOutput);
		serializeRetorno(finalizarOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeRetorno(FinalizarOutput finalizarOutput, StringBuilder sb, List<Object> appended) {
		sb.append("retorno=<");
		if (finalizarOutput.retorno == null) {
			sb.append("null");
		} else {
			finalizarOutput.retorno.toString(sb, appended);
		}
		sb.append('>');
	}
}
