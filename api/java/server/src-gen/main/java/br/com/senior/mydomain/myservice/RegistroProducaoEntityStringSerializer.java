/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.List;

public class RegistroProducaoEntityStringSerializer {
	
	public static final RegistroProducaoEntityStringSerializer INSTANCE = new RegistroProducaoEntityStringSerializer();
    
    public void serialize(RegistroProducaoEntity registroProducao, StringBuilder sb, List<Object> appended) {
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
		sb.append(", ").append(", ");
		sb.append(']');
	}
	
	protected void serializeId(RegistroProducaoEntity registroProducao, StringBuilder sb) {
		sb.append("id=").append(registroProducao.getId() == null ? "null" : registroProducao.getId());
	}
	
	protected void serializePeca(RegistroProducaoEntity registroProducao, StringBuilder sb, List<Object> appended) {
		sb.append("peca=<");
		if (registroProducao.getPeca() == null) {
			sb.append("null");
		} else {
			registroProducao.getPeca().toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeFuncionario(RegistroProducaoEntity registroProducao, StringBuilder sb, List<Object> appended) {
		sb.append("funcionario=<");
		if (registroProducao.getFuncionario() == null) {
			sb.append("null");
		} else {
			registroProducao.getFuncionario().toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeMaquina(RegistroProducaoEntity registroProducao, StringBuilder sb, List<Object> appended) {
		sb.append("maquina=<");
		if (registroProducao.getMaquina() == null) {
			sb.append("null");
		} else {
			registroProducao.getMaquina().toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeDataInicio(RegistroProducaoEntity registroProducao, StringBuilder sb) {
		sb.append("dataInicio=").append(registroProducao.getDataInicio() == null ? "null" : registroProducao.getDataInicio());
	}
	
	protected void serializeDataFinal(RegistroProducaoEntity registroProducao, StringBuilder sb) {
		sb.append("dataFinal=").append(registroProducao.getDataFinal() == null ? "null" : registroProducao.getDataFinal());
	}
}
