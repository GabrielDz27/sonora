package br.com.senior.mydomain.myservice;

import java.util.List;

public class RecordRegistroProducaoStringSerializer {
    
	public static final RecordRegistroProducaoStringSerializer INSTANCE = new RecordRegistroProducaoStringSerializer();
    
    public void serialize(RecordRegistroProducao recordRegistroProducao, StringBuilder sb, List<Object> appended) {
		sb.append(recordRegistroProducao.getClass().getSimpleName()).append(" [");
		if (appended.contains(recordRegistroProducao)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(recordRegistroProducao);
		serializeId(recordRegistroProducao, sb);
		sb.append(", ");
		serializePeca(recordRegistroProducao, sb, appended);
		sb.append(", ");
		serializeFuncionario(recordRegistroProducao, sb, appended);
		sb.append(", ");
		serializeMaquina(recordRegistroProducao, sb, appended);
		sb.append(", ");
		serializeDataInicio(recordRegistroProducao, sb);
		sb.append(", ");
		serializeDataFinal(recordRegistroProducao, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeId(RecordRegistroProducao recordRegistroProducao, StringBuilder sb) {
		sb.append("id=").append(recordRegistroProducao.id == null ? "null" : recordRegistroProducao.id);
	}
	
	protected void serializePeca(RecordRegistroProducao recordRegistroProducao, StringBuilder sb, List<Object> appended) {
		sb.append("peca=<");
		if (recordRegistroProducao.peca == null) {
			sb.append("null");
		} else {
			recordRegistroProducao.peca.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeFuncionario(RecordRegistroProducao recordRegistroProducao, StringBuilder sb, List<Object> appended) {
		sb.append("funcionario=<");
		if (recordRegistroProducao.funcionario == null) {
			sb.append("null");
		} else {
			recordRegistroProducao.funcionario.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeMaquina(RecordRegistroProducao recordRegistroProducao, StringBuilder sb, List<Object> appended) {
		sb.append("maquina=<");
		if (recordRegistroProducao.maquina == null) {
			sb.append("null");
		} else {
			recordRegistroProducao.maquina.toString(sb, appended);
		}
		sb.append('>');
	}
	
	protected void serializeDataInicio(RecordRegistroProducao recordRegistroProducao, StringBuilder sb) {
		sb.append("dataInicio=").append(recordRegistroProducao.dataInicio == null ? "null" : recordRegistroProducao.dataInicio);
	}
	
	protected void serializeDataFinal(RecordRegistroProducao recordRegistroProducao, StringBuilder sb) {
		sb.append("dataFinal=").append(recordRegistroProducao.dataFinal == null ? "null" : recordRegistroProducao.dataFinal);
	}
}
