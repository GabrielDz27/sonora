package br.com.senior.mydomain.myservice;

import java.util.List;

public class GetPecaPendenteOutputStringSerializer {
    
	public static final GetPecaPendenteOutputStringSerializer INSTANCE = new GetPecaPendenteOutputStringSerializer();
    
    public void serialize(GetPecaPendenteOutput getPecaPendenteOutput, StringBuilder sb, List<Object> appended) {
		sb.append(getPecaPendenteOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(getPecaPendenteOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(getPecaPendenteOutput);
		serializePeca(getPecaPendenteOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializePeca(GetPecaPendenteOutput getPecaPendenteOutput, StringBuilder sb, List<Object> appended) {
		sb.append("peca=<");
		if (getPecaPendenteOutput.peca == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = getPecaPendenteOutput.peca.size() - 1;
			for (int i = 0; i <= last; i++) {
				getPecaPendenteOutput.peca.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
}
