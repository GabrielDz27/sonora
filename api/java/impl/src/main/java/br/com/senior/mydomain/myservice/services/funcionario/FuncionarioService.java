package br.com.senior.mydomain.myservice.services.funcionario;

import br.com.senior.mydomain.myservice.Funcionario;
import br.com.senior.mydomain.myservice.FuncionarioEntity;
import br.com.senior.mydomain.myservice.repositories.funcionario.FuncionarioRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service
public class FuncionarioService {

    @Inject
    private FuncionarioRepository funcionarioRepository;

    public void desativarFuncioario(Funcionario.Id id) {
        funcionarioRepository.desativar(UUID.fromString(String.valueOf(id)));
    }

    public FuncionarioEntity findFuncionanrioByUsername(String username) {
        return funcionarioRepository.findFuncionarioByUsername(username);
    }
}
