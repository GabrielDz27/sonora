package br.com.senior.mydomain.myservice.handler.funcionario;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.Funcionario;
import br.com.senior.mydomain.myservice.FuncionarioCrudServiceImpl;
import br.com.senior.mydomain.myservice.services.funcionario.FuncionarioService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
@Primary
public class FuncionanrioCrudServiceCustomImpl extends FuncionarioCrudServiceImpl {

    @Inject
    private FuncionarioService funcionarioService;

    @Override
    public void deleteFuncionario(Funcionario.Id id) {
        funcionarioService.desativarFuncioario(id);

        //throw new ServiceException(ErrorCategory.BAD_REQUEST, "Não pode deletar um funcionario");
        //super.deleteFuncionario(id);
    }
}
