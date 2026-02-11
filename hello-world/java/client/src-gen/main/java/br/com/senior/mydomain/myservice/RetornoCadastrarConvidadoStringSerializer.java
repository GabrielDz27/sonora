package br.com.senior.mydomain.myservice;

import java.util.List;

public class RetornoCadastrarConvidadoStringSerializer {
    
	public static final RetornoCadastrarConvidadoStringSerializer INSTANCE = new RetornoCadastrarConvidadoStringSerializer();
    
    public void serialize(RetornoCadastrarConvidado retornoCadastrarConvidado, StringBuilder sb, List<Object> appended) {
		sb.append(retornoCadastrarConvidado.getClass().getSimpleName()).append(" [");
		if (appended.contains(retornoCadastrarConvidado)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(retornoCadastrarConvidado);
		serializeNome(retornoCadastrarConvidado, sb);
		sb.append(", ");
		serializeNomeSocial(retornoCadastrarConvidado, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeNome(RetornoCadastrarConvidado retornoCadastrarConvidado, StringBuilder sb) {
		sb.append("nome=").append(retornoCadastrarConvidado.nome == null ? "null" : retornoCadastrarConvidado.nome);
	}
	
	protected void serializeNomeSocial(RetornoCadastrarConvidado retornoCadastrarConvidado, StringBuilder sb) {
		sb.append("nomeSocial=").append(retornoCadastrarConvidado.nomeSocial == null ? "null" : retornoCadastrarConvidado.nomeSocial);
	}
}
