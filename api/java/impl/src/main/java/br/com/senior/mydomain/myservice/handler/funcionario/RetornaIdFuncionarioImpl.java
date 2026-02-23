package br.com.senior.mydomain.myservice.handler.funcionario;

import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.mydomain.myservice.FuncionarioEntity;
import br.com.senior.mydomain.myservice.RetornaIdFuncionario;
import br.com.senior.mydomain.myservice.RetornaIdFuncionarioInput;
import br.com.senior.mydomain.myservice.RetornaIdFuncionarioOutput;
import br.com.senior.mydomain.myservice.repositories.funcionario.FuncionarioRepository;
import br.com.senior.mydomain.myservice.services.funcionario.FuncionarioService;

import javax.inject.Inject;

@HandlerImpl
public class RetornaIdFuncionarioImpl implements RetornaIdFuncionario {

    @Inject
    private FuncionarioService funcionarioService;

    @Override
    public RetornaIdFuncionarioOutput retornaIdFuncionario(RetornaIdFuncionarioInput request) {
        FuncionarioEntity funcionario = funcionarioService.findFuncionanrioByUsername(request.username);

        RetornaIdFuncionarioOutput output = new RetornaIdFuncionarioOutput();
        output.id = funcionario.getId().toString();
        output.nome = funcionario.getNome();

        return null;
    }
}
