/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.mydomain.myservice;

import java.util.List;

public class FuncionarioEntityStringSerializer {
	
	public static final FuncionarioEntityStringSerializer INSTANCE = new FuncionarioEntityStringSerializer();
    
    public void serialize(FuncionarioEntity funcionario, StringBuilder sb, List<Object> appended) {
		sb.append(funcionario.getClass().getSimpleName()).append(" [");
		if (appended.contains(funcionario)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(funcionario);
		serializeId(funcionario, sb);
		sb.append(", ");
		serializeNome(funcionario, sb);
		sb.append(", ");
		serializeMatricula(funcionario, sb);
		sb.append(", ");
		serializeCargo(funcionario, sb);
		sb.append(", ");
		serializeTurno(funcionario, sb);
		sb.append(", ");
		serializeAtivo(funcionario, sb);
		sb.append(", ");
		serializeUsername(funcionario, sb);
		sb.append(", ").append(", ");
		sb.append(']');
	}
	
	protected void serializeId(FuncionarioEntity funcionario, StringBuilder sb) {
		sb.append("id=").append(funcionario.getId() == null ? "null" : funcionario.getId());
	}
	
	protected void serializeNome(FuncionarioEntity funcionario, StringBuilder sb) {
		sb.append("nome=").append(funcionario.getNome() == null ? "null" : funcionario.getNome());
	}
	
	protected void serializeMatricula(FuncionarioEntity funcionario, StringBuilder sb) {
		sb.append("matricula=").append(funcionario.getMatricula() == null ? "null" : funcionario.getMatricula());
	}
	
	protected void serializeCargo(FuncionarioEntity funcionario, StringBuilder sb) {
		sb.append("cargo=").append(funcionario.getCargo() == null ? "null" : funcionario.getCargo());
	}
	
	protected void serializeTurno(FuncionarioEntity funcionario, StringBuilder sb) {
		sb.append("turno=").append(funcionario.getTurno() == null ? "null" : funcionario.getTurno());
	}
	
	protected void serializeAtivo(FuncionarioEntity funcionario, StringBuilder sb) {
		sb.append("ativo=").append(funcionario.getAtivo() == null ? "null" : funcionario.getAtivo());
	}
	
	protected void serializeUsername(FuncionarioEntity funcionario, StringBuilder sb) {
		sb.append("username=").append(funcionario.getUsername() == null ? "null" : funcionario.getUsername());
	}
}
