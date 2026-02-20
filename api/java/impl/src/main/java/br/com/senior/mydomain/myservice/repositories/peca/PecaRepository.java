package br.com.senior.mydomain.myservice.repositories.peca;

import br.com.senior.mydomain.myservice.PecaBaseRepository;
import br.com.senior.mydomain.myservice.StatusPeca;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PecaRepository extends PecaBaseRepository, PecaRepositoryCustom {

    @Query("update my_domain.my_service.PecaEntity p set status = ?1 where id = ?2")
    @Modifying
    void updateStatusById(StatusPeca status, UUID id);
}
