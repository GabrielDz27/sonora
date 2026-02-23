package br.com.senior.mydomain.myservice;

import java.util.List;

public class RetornaIdFuncionarioOutputStringSerializer {
    
	public static final RetornaIdFuncionarioOutputStringSerializer INSTANCE = new RetornaIdFuncionarioOutputStringSerializer();
    
    public void serialize(RetornaIdFuncionarioOutput retornaIdFuncionarioOutput, StringBuilder sb, List<Object> appended) {
		sb.append(retornaIdFuncionarioOutput.getClass().getSimpleName()).append(" [");
		if (appended.contains(retornaIdFuncionarioOutput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(retornaIdFuncionarioOutput);
		serializeNome(retornaIdFuncionarioOutput, sb);
		sb.append(", ");
		serializeId(retornaIdFuncionarioOutput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeNome(RetornaIdFuncionarioOutput retornaIdFuncionarioOutput, StringBuilder sb) {
		sb.append("nome=").append(retornaIdFuncionarioOutput.nome == null ? "null" : retornaIdFuncionarioOutput.nome);
	}
	
	protected void serializeId(RetornaIdFuncionarioOutput retornaIdFuncionarioOutput, StringBuilder sb) {
		sb.append("id=").append(retornaIdFuncionarioOutput.id == null ? "null" : retornaIdFuncionarioOutput.id);
	}
}
