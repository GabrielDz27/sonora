/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.List;

public class Registro_producaoEntityStringSerializer {
	
	public static final Registro_producaoEntityStringSerializer INSTANCE = new Registro_producaoEntityStringSerializer();
    
    public void serialize(Registro_producaoEntity registro_producao, StringBuilder sb, List<Object> appended) {
		sb.append(registro_producao.getClass().getSimpleName()).append(" [");
		if (appended.contains(registro_producao)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(registro_producao);
		serializeId(registro_producao, sb);
		sb.append(", ");
		serializePeca(registro_producao, sb, appended);
		sb.append(", ");
		serializeFuncionario(registro_producao, sb, appended);
		sb.append(", ");
		serializeMaquina(registro_producao, sb, appended);
		sb.append(", ");
		serializeDataInicio(registro_producao, sb);
		sb.append(", ");
		serializeDataFinal(registro_producao, sb);
		sb.append(", ").append(", ");
		sb.append(']');
	}
	
	protected void serializeId(Registro_producaoEntity registro_producao, StringBuilder sb) {
		sb.append("id=").append(registro_producao.getId() == null ? "null" : registro_producao.getId());
	}
	
	protected void serializePeca(Registro_producaoEntity registro_producao, StringBuilder sb, List<Object> appended) {
		sb.append("peca=<");
		if (registro_producao.getPeca() == null) {
			sb.append("null");
		} else {
			registro_producao.getPeca().toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeFuncionario(Registro_producaoEntity registro_producao, StringBuilder sb, List<Object> appended) {
		sb.append("funcionario=<");
		if (registro_producao.getFuncionario() == null) {
			sb.append("null");
		} else {
			registro_producao.getFuncionario().toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeMaquina(Registro_producaoEntity registro_producao, StringBuilder sb, List<Object> appended) {
		sb.append("maquina=<");
		if (registro_producao.getMaquina() == null) {
			sb.append("null");
		} else {
			registro_producao.getMaquina().toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeDataInicio(Registro_producaoEntity registro_producao, StringBuilder sb) {
		sb.append("dataInicio=").append(registro_producao.getDataInicio() == null ? "null" : registro_producao.getDataInicio());
	}
	
	protected void serializeDataFinal(Registro_producaoEntity registro_producao, StringBuilder sb) {
		sb.append("dataFinal=").append(registro_producao.getDataFinal() == null ? "null" : registro_producao.getDataFinal());
	}
}
