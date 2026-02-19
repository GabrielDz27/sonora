package br.com.senior.mydomain.myservice;

import java.util.List;

public class PecaFuncionarioStringSerializer {
    
	public static final PecaFuncionarioStringSerializer INSTANCE = new PecaFuncionarioStringSerializer();
    
    public void serialize(PecaFuncionario pecaFuncionario, StringBuilder sb, List<Object> appended) {
		sb.append(pecaFuncionario.getClass().getSimpleName()).append(" [");
		if (appended.contains(pecaFuncionario)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(pecaFuncionario);
		serializePeca(pecaFuncionario, sb, appended);
		sb.append(", ");
		serializeFuncionario(pecaFuncionario, sb, appended);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializePeca(PecaFuncionario pecaFuncionario, StringBuilder sb, List<Object> appended) {
		sb.append("peca=<");
		if (pecaFuncionario.peca == null) {
			sb.append("null");
		} else {
			pecaFuncionario.peca.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeFuncionario(PecaFuncionario pecaFuncionario, StringBuilder sb, List<Object> appended) {
		sb.append("funcionario=<");
		if (pecaFuncionario.funcionario == null) {
			sb.append("null");
		} else {
			pecaFuncionario.funcionario.toString(sb, appended);
		}
		sb.append('>');
	}
}
