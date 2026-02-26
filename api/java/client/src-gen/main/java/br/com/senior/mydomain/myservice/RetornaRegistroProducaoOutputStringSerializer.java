package br.com.senior.mydomain.myservice;

import java.util.List;

public class RetornaRegistroProducaoOutputStringSerializer {
    
	public static final RetornaRegistroProducaoOutputStringSerializer INSTANCE = new RetornaRegistroProducaoOutputStringSerializer();
    
    public void serialize(RetornaRegistroProducaoOutput retornaRegistroProducaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append(retornaRegistroProducaoOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(retornaRegistroProducaoOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(retornaRegistroProducaoOutput);
		serializeRetorno(retornaRegistroProducaoOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeRetorno(RetornaRegistroProducaoOutput retornaRegistroProducaoOutput, StringBuilder sb, List<Object> appended) {
		sb.append("retorno=<");
		if (retornaRegistroProducaoOutput.retorno == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = retornaRegistroProducaoOutput.retorno.size() - 1;
			for (int i = 0; i <= last; i++) {
				retornaRegistroProducaoOutput.retorno.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
}
