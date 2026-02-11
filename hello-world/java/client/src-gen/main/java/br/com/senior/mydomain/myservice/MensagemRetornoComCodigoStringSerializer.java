package br.com.senior.mydomain.myservice;

import java.util.List;

public class MensagemRetornoComCodigoStringSerializer {
    
	public static final MensagemRetornoComCodigoStringSerializer INSTANCE = new MensagemRetornoComCodigoStringSerializer();
    
    public void serialize(MensagemRetornoComCodigo mensagemRetornoComCodigo, StringBuilder sb, List<Object> appended) {
		sb.append(mensagemRetornoComCodigo.getClass().getSimpleName()).append(" [");
		if (appended.contains(mensagemRetornoComCodigo)) {
			sb.append("<Previously appended object>").append(']');
			return;
		}
		appended.add(mensagemRetornoComCodigo);
		serializeMensagemretorno(mensagemRetornoComCodigo, sb);
		sb.append(", ");
		serializeCodigoCadastrado(mensagemRetornoComCodigo, sb);
		sb.append(", ");
		serializeContemErro(mensagemRetornoComCodigo, sb);
		sb.append(", ");
		sb.append(']');
	}
	
	protected void serializeMensagemretorno(MensagemRetornoComCodigo mensagemRetornoComCodigo, StringBuilder sb) {
		sb.append("mensagemretorno=").append(mensagemRetornoComCodigo.mensagemretorno == null ? "null" : mensagemRetornoComCodigo.mensagemretorno);
	}
	
	protected void serializeCodigoCadastrado(MensagemRetornoComCodigo mensagemRetornoComCodigo, StringBuilder sb) {
		sb.append("codigoCadastrado=").append(mensagemRetornoComCodigo.codigoCadastrado == null ? "null" : mensagemRetornoComCodigo.codigoCadastrado);
	}
	
	protected void serializeContemErro(MensagemRetornoComCodigo mensagemRetornoComCodigo, StringBuilder sb) {
		sb.append("contemErro=").append(mensagemRetornoComCodigo.contemErro == null ? "null" : mensagemRetornoComCodigo.contemErro);
	}
}
