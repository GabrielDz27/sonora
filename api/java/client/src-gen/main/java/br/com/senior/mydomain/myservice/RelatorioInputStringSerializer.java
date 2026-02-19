package br.com.senior.mydomain.myservice;

import java.util.List;

public class RelatorioInputStringSerializer {
    
	public static final RelatorioInputStringSerializer INSTANCE = new RelatorioInputStringSerializer();
    
    public void serialize(RelatorioInput relatorioInput, StringBuilder sb, List<Object> appended) {
		sb.append(relatorioInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(relatorioInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(relatorioInput);
		serializeDataInicio(relatorioInput, sb);
		sb.append(", ");
		serializeDataFinal(relatorioInput, sb);
		sb.append(", ");
		serializeTipoRelatorio(relatorioInput, sb);
		sb.append(", ");
		serializeTurno(relatorioInput, sb);
		sb.append(", ");
		serializeFuncionario(relatorioInput, sb);
		sb.append(", ");
		serializeMaquina(relatorioInput, sb);
		sb.append(", ");
		serializeCodigoDesenho(relatorioInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeDataInicio(RelatorioInput relatorioInput, StringBuilder sb) {
		sb.append("dataInicio=").append(relatorioInput.dataInicio == null ? "null" : relatorioInput.dataInicio);
	}
	
	protected void serializeDataFinal(RelatorioInput relatorioInput, StringBuilder sb) {
		sb.append("dataFinal=").append(relatorioInput.dataFinal == null ? "null" : relatorioInput.dataFinal);
	}
	
	protected void serializeTipoRelatorio(RelatorioInput relatorioInput, StringBuilder sb) {
		sb.append("tipoRelatorio=").append(relatorioInput.tipoRelatorio == null ? "null" : relatorioInput.tipoRelatorio);
	}
	
	protected void serializeTurno(RelatorioInput relatorioInput, StringBuilder sb) {
		sb.append("turno=").append(relatorioInput.turno == null ? "null" : relatorioInput.turno);
	}
	
	protected void serializeFuncionario(RelatorioInput relatorioInput, StringBuilder sb) {
		sb.append("funcionario=").append(relatorioInput.funcionario == null ? "null" : relatorioInput.funcionario);
	}
	
	protected void serializeMaquina(RelatorioInput relatorioInput, StringBuilder sb) {
		sb.append("maquina=").append(relatorioInput.maquina == null ? "null" : relatorioInput.maquina);
	}
	
	protected void serializeCodigoDesenho(RelatorioInput relatorioInput, StringBuilder sb) {
		sb.append("codigoDesenho=").append(relatorioInput.codigoDesenho == null ? "null" : relatorioInput.codigoDesenho);
	}
}
