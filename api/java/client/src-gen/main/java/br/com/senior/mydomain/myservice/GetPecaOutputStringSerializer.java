package br.com.senior.mydomain.myservice;

import java.util.List;

public class GetPecaOutputStringSerializer {
    
	public static final GetPecaOutputStringSerializer INSTANCE = new GetPecaOutputStringSerializer();
    
    public void serialize(GetPecaOutput getPecaOutput, StringBuilder sb, List<Object> appended) {
		sb.append(getPecaOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(getPecaOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(getPecaOutput);
		serializePeca(getPecaOutput, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializePeca(GetPecaOutput getPecaOutput, StringBuilder sb, List<Object> appended) {
		sb.append("peca=<");
		if (getPecaOutput.peca == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = getPecaOutput.peca.size() - 1;
			for (int i = 0; i <= last; i++) {
				getPecaOutput.peca.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
}
