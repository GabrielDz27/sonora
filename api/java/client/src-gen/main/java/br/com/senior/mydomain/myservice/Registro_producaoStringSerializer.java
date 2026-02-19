package br.com.senior.mydomain.myservice;

import java.util.List;

public class Registro_producaoStringSerializer {
    
	public static final Registro_producaoStringSerializer INSTANCE = new Registro_producaoStringSerializer();
    
    public void serialize(Registro_producao registro_producao, StringBuilder sb, List<Object> appended) {
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
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(Registro_producao registro_producao, StringBuilder sb) {
		sb.append("id=").append(registro_producao.id == null ? "null" : registro_producao.id);
	}
	
	protected void serializePeca(Registro_producao registro_producao, StringBuilder sb, List<Object> appended) {
		sb.append("peca=<");
		if (registro_producao.peca == null) {
			sb.append("null");
		} else {
			registro_producao.peca.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeFuncionario(Registro_producao registro_producao, StringBuilder sb, List<Object> appended) {
		sb.append("funcionario=<");
		if (registro_producao.funcionario == null) {
			sb.append("null");
		} else {
			registro_producao.funcionario.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeMaquina(Registro_producao registro_producao, StringBuilder sb, List<Object> appended) {
		sb.append("maquina=<");
		if (registro_producao.maquina == null) {
			sb.append("null");
		} else {
			registro_producao.maquina.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeDataInicio(Registro_producao registro_producao, StringBuilder sb) {
		sb.append("dataInicio=").append(registro_producao.dataInicio == null ? "null" : registro_producao.dataInicio);
	}
	
	protected void serializeDataFinal(Registro_producao registro_producao, StringBuilder sb) {
		sb.append("dataFinal=").append(registro_producao.dataFinal == null ? "null" : registro_producao.dataFinal);
	}
}
