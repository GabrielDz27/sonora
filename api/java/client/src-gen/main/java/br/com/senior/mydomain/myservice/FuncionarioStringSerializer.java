package br.com.senior.mydomain.myservice;

import java.util.List;

public class FuncionarioStringSerializer {
    
	public static final FuncionarioStringSerializer INSTANCE = new FuncionarioStringSerializer();
    
    public void serialize(Funcionario funcionario, StringBuilder sb, List<Object> appended) {
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
		sb.append(']');
	}
	
	protected void serializeId(Funcionario funcionario, StringBuilder sb) {
		sb.append("id=").append(funcionario.id == null ? "null" : funcionario.id);
	}
	
	protected void serializeNome(Funcionario funcionario, StringBuilder sb) {
		sb.append("nome=").append(funcionario.nome == null ? "null" : funcionario.nome);
	}
	
	protected void serializeMatricula(Funcionario funcionario, StringBuilder sb) {
		sb.append("matricula=").append(funcionario.matricula == null ? "null" : funcionario.matricula);
	}
	
	protected void serializeCargo(Funcionario funcionario, StringBuilder sb) {
		sb.append("cargo=").append(funcionario.cargo == null ? "null" : funcionario.cargo);
	}
	
	protected void serializeTurno(Funcionario funcionario, StringBuilder sb) {
		sb.append("turno=").append(funcionario.turno == null ? "null" : funcionario.turno);
	}
	
	protected void serializeAtivo(Funcionario funcionario, StringBuilder sb) {
		sb.append("ativo=").append(funcionario.ativo == null ? "null" : funcionario.ativo);
	}
}
