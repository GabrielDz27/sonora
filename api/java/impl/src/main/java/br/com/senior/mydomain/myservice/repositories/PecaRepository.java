package br.com.senior.mydomain.myservice.repositories;

import br.com.senior.mydomain.myservice.PecaBaseRepository;
import br.com.senior.mydomain.myservice.StatusPeca;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PecaRepository extends PecaBaseRepository {
    void updateStatusById(StatusPeca status, UUID uuid);
}
