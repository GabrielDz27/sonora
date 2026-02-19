package br.com.senior.mydomain.myservice;

import java.util.List;

public class RetornoRelatorioStringSerializer {
    
	public static final RetornoRelatorioStringSerializer INSTANCE = new RetornoRelatorioStringSerializer();
    
    public void serialize(RetornoRelatorio retornoRelatorio, StringBuilder sb, List<Object> appended) {
		sb.append(retornoRelatorio.getClass().getSimpleName()).append(" [");
		if (appended.contains(retornoRelatorio)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(retornoRelatorio);
		serializeMaquinaTrabalhando(retornoRelatorio, sb, appended);
		sb.append(", ");
		serializePecaMortas(retornoRelatorio, sb);
		sb.append(", ");
		serializePecaFuncionario(retornoRelatorio, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeMaquinaTrabalhando(RetornoRelatorio retornoRelatorio, StringBuilder sb, List<Object> appended) {
		sb.append("maquinaTrabalhando=<");
		if (retornoRelatorio.maquinaTrabalhando == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = retornoRelatorio.maquinaTrabalhando.size() - 1;
			for (int i = 0; i <= last; i++) {
				retornoRelatorio.maquinaTrabalhando.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
	
	protected void serializePecaMortas(RetornoRelatorio retornoRelatorio, StringBuilder sb) {
		sb.append("pecaMortas=").append(retornoRelatorio.pecaMortas == null ? "null" : retornoRelatorio.pecaMortas);
	}
	
	protected void serializePecaFuncionario(RetornoRelatorio retornoRelatorio, StringBuilder sb, List<Object> appended) {
		sb.append("pecaFuncionario=<");
		if (retornoRelatorio.pecaFuncionario == null) {
			sb.append("null");
		} else {
			sb.append('[');
			int last = retornoRelatorio.pecaFuncionario.size() - 1;
			for (int i = 0; i <= last; i++) {
				retornoRelatorio.pecaFuncionario.get(i).toString(sb, appended);
				if (i < last) {
					sb.append(", ");
				}
			}
			sb.append(']');
		}
		sb.append('>');
	}
}
