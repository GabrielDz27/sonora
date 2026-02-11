package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.HandlerImpl;
import org.checkerframework.checker.units.qual.C;

@HandlerImpl
public class CadastrarEventoImpl implements CadastrarEvento {
    @Override
    public CadastrarEventoOutput cadastrarEvento(CadastrarEventoInput request) {

        final MensagemRetornoComCodigo mensagem = new MensagemRetornoComCodigo();
        mensagem.codigoCadastrado = "1";
        mensagem.mensagemretorno = "Evento cadastrado com sucesso!";
        mensagem.contemErro = false;

        final RetornoCadastrarEvento recorder = new RetornoCadastrarEvento();
        recorder.codigoCadastrado = "1";
        recorder.mensagemretorno = "Evento cadastrado com sucesso!";
        recorder.contemErro = false;
        recorder.nome = request.nome;
        recorder.apenasColaboradores = request.apenasColaboradores;
        recorder.lotacaoMaxima = request.lotacaoMaxima;
        recorder.data = request.data;

        final CadastrarEventoOutput ret = new CadastrarEventoOutput();
        ret.retorno = recorder;

        return ret;
    }
}
