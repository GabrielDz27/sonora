package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.model.HandlerImpl;

@HandlerImpl
public class CadastrarConvidadoImpl implements CadastrarConvidado{

    @Override
    public CadastrarConvidadoOutput cadastrarConvidado(CadastrarConvidadoInput request) {

        RetornoCadastrarConvidado retorn = new RetornoCadastrarConvidado();
        retorn.nome = request.nome.nome;
        retorn.nomeSocial = request.nome.nomeSocial;

        var ret = new CadastrarConvidadoOutput();
        ret.convidado = retorn;
        ret.resultado = TipoSituacao.CADASTRADO_NOVO;
        return ret;
    }
}
