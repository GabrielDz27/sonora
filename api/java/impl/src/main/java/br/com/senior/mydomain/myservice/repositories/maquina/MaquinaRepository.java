package br.com.senior.mydomain.myservice.repositories.maquina;

import br.com.senior.mydomain.myservice.MaquinaBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinaRepository extends MaquinaBaseRepository, MaquinaRepositoryCustom {

}
