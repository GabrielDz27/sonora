package br.com.senior.mydomain.myservice;

import java.util.List;

public class RegistroProducaoStringSerializer {
    
	public static final RegistroProducaoStringSerializer INSTANCE = new RegistroProducaoStringSerializer();
    
    public void serialize(RegistroProducao registroProducao, StringBuilder sb, List<Object> appended) {
		sb.append(registroProducao.getClass().getSimpleName()).append(" [");
		if (appended.contains(registroProducao)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(registroProducao);
		serializeId(registroProducao, sb);
		sb.append(", ");
		serializePeca(registroProducao, sb, appended);
		sb.append(", ");
		serializeFuncionario(registroProducao, sb, appended);
		sb.append(", ");
		serializeMaquina(registroProducao, sb, appended);
		sb.append(", ");
		serializeDataInicio(registroProducao, sb);
		sb.append(", ");
		serializeDataFinal(registroProducao, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(RegistroProducao registroProducao, StringBuilder sb) {
		sb.append("id=").append(registroProducao.id == null ? "null" : registroProducao.id);
	}
	
	protected void serializePeca(RegistroProducao registroProducao, StringBuilder sb, List<Object> appended) {
		sb.append("peca=<");
		if (registroProducao.peca == null) {
			sb.append("null");
		} else {
			registroProducao.peca.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeFuncionario(RegistroProducao registroProducao, StringBuilder sb, List<Object> appended) {
		sb.append("funcionario=<");
		if (registroProducao.funcionario == null) {
			sb.append("null");
		} else {
			registroProducao.funcionario.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeMaquina(RegistroProducao registroProducao, StringBuilder sb, List<Object> appended) {
		sb.append("maquina=<");
		if (registroProducao.maquina == null) {
			sb.append("null");
		} else {
			registroProducao.maquina.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeDataInicio(RegistroProducao registroProducao, StringBuilder sb) {
		sb.append("dataInicio=").append(registroProducao.dataInicio == null ? "null" : registroProducao.dataInicio);
	}
	
	protected void serializeDataFinal(RegistroProducao registroProducao, StringBuilder sb) {
		sb.append("dataFinal=").append(registroProducao.dataFinal == null ? "null" : registroProducao.dataFinal);
	}
}
