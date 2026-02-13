package br.com.senior.mydomain.myservice.convidado;

import br.com.senior.mydomain.myservice.ConvidadoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface ConvidadoRepositoryCustom {

    String findNomeByIdCustom(UUID id);

    List<ConvidadoEntity> getAll();
}
