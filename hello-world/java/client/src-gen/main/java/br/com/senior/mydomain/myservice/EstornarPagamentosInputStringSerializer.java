package br.com.senior.mydomain.myservice;

import java.util.List;

public class EstornarPagamentosInputStringSerializer {
    
	public static final EstornarPagamentosInputStringSerializer INSTANCE = new EstornarPagamentosInputStringSerializer();
    
    public void serialize(EstornarPagamentosInput estornarPagamentosInput, StringBuilder sb, List<Object> appended) {
		sb.append(estornarPagamentosInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(estornarPagamentosInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(estornarPagamentosInput);
		serializeCodigoIngresso(estornarPagamentosInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeCodigoIngresso(EstornarPagamentosInput estornarPagamentosInput, StringBuilder sb) {
		sb.append("codigoIngresso=").append(estornarPagamentosInput.codigoIngresso == null ? "null" : estornarPagamentosInput.codigoIngresso);
	}
}
