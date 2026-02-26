package br.com.senior.mydomain.myservice.repositories.maquina;

import br.com.senior.mydomain.myservice.MaquinaBaseRepository;
import br.com.senior.mydomain.myservice.MaquinaTrabalhando;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MaquinaRepository extends MaquinaBaseRepository, MaquinaRepositoryCustom {

    @Query("SELECT COUNT(p) > 0 " +
            " FROM my_domain.my_service.MaquinaEntity p WHERE status = 'ATIVO' and id = ?1")
    boolean isMaquinaStatusNotAtiva(UUID idMaquina);

}
