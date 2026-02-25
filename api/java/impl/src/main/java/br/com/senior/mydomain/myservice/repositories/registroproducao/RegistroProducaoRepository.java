package br.com.senior.mydomain.myservice.repositories.registroproducao;

import br.com.senior.mydomain.myservice.RegistroProducaoBaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface RegistroProducaoRepository extends RegistroProducaoBaseRepository {

    @Query("select COUNT(r) > 0 "+
                " FROM my_domain.my_service.RegistroProducaoEntity r WHERE data_final IS NULL and data_inicio >= ?1 and maquina = ?2")
    boolean isMaquinaUsada(LocalDateTime agora, UUID idMaquina);

    @Query("update my_domain.my_service.RegistroProducaoEntity r set data_final = ?1 where id = ?2")
    @Modifying
    void updateStatusById(LocalDateTime agora, UUID uuid);
}
