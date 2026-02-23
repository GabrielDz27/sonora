package br.com.senior.mydomain.myservice;

import java.util.List;

public class RetornaIdFuncionarioInputStringSerializer {
    
	public static final RetornaIdFuncionarioInputStringSerializer INSTANCE = new RetornaIdFuncionarioInputStringSerializer();
    
    public void serialize(RetornaIdFuncionarioInput retornaIdFuncionarioInput, StringBuilder sb, List<Object> appended) {
		sb.append(retornaIdFuncionarioInput.getClass().getSimpleName()).append(" [");
		if (appended.contains(retornaIdFuncionarioInput)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(retornaIdFuncionarioInput);
		serializeUsername(retornaIdFuncionarioInput, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeUsername(RetornaIdFuncionarioInput retornaIdFuncionarioInput, StringBuilder sb) {
		sb.append("username=").append(retornaIdFuncionarioInput.username == null ? "null" : retornaIdFuncionarioInput.username);
	}
}
