package br.com.senior.mydomain.myservice.ingresso;

import br.com.senior.mydomain.myservice.IngressoBaseRepository;
import br.com.senior.mydomain.myservice.IngressoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngressoRepository extends IngressoBaseRepository, IngressoRepositoryCustom {

    @Query(value = "select i from my_domain.my_service.IngressoEntity i " //
        + "join my_domain.my_service.ConvidadoEntity c on c.id = i.convidado " //
        + "where c.nome like %%?1", nativeQuery = true)
    List<IngressoEntity> findByNomeConvidado(String nome);

}
