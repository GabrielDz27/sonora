package br.com.senior.mydomain.myservice.convidado;

import br.com.senior.mydomain.myservice.ConvidadoBaseRepository;
import br.com.senior.mydomain.myservice.ConvidadoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ConvidadoRepository extends ConvidadoBaseRepository, ConvidadoRepositoryCustom  {

    List<ConvidadoEntity> findByNomeContainingIgnoreCase(String nome);

    @Query("select c from my_domain.my_service.ConvidadoEntity c where c.nome like %?1%")
    List<ConvidadoEntity> findByNomeContainingIgnoreCaseWithQuery(String nome);

    @Query("update my_domain.my_service.ConvidadoEntity c set nome = ?1 where id = ?2")
    @Modifying // usado para uso de DML
    void updateNomeById(String nome, UUID id);
}
