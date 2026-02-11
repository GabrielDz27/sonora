package br.com.senior.mydomain.myservice;

import java.util.List;

public class EntradaCadastrarConvidadoStringSerializer {
    
	public static final EntradaCadastrarConvidadoStringSerializer INSTANCE = new EntradaCadastrarConvidadoStringSerializer();
    
    public void serialize(EntradaCadastrarConvidado entradaCadastrarConvidado, StringBuilder sb, List<Object> appended) {
		sb.append(entradaCadastrarConvidado.getClass().getSimpleName()).append(" [");
		if (appended.contains(entradaCadastrarConvidado)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(entradaCadastrarConvidado);
		serializeNome(entradaCadastrarConvidado, sb);
		sb.append(", ");
		serializeNomeSocial(entradaCadastrarConvidado, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeNome(EntradaCadastrarConvidado entradaCadastrarConvidado, StringBuilder sb) {
		sb.append("nome=").append(entradaCadastrarConvidado.nome == null ? "null" : entradaCadastrarConvidado.nome);
	}
	
	protected void serializeNomeSocial(EntradaCadastrarConvidado entradaCadastrarConvidado, StringBuilder sb) {
		sb.append("nomeSocial=").append(entradaCadastrarConvidado.nomeSocial == null ? "null" : entradaCadastrarConvidado.nomeSocial);
	}
}
