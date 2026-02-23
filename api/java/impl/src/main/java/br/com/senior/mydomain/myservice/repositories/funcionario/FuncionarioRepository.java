package br.com.senior.mydomain.myservice.repositories.funcionario;

import br.com.senior.mydomain.myservice.FuncionarioBaseRepository;
import br.com.senior.mydomain.myservice.FuncionarioEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FuncionarioRepository extends FuncionarioBaseRepository{

    @Query("update my_domain.my_service.FuncionarioEntity f set ativo = false where id = ?2")
    @Modifying
    void desativar (UUID id);

    FuncionarioEntity findFuncionarioByUsername(String username);
}
