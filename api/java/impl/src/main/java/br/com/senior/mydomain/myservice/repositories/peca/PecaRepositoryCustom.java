package br.com.senior.mydomain.myservice.repositories.peca;

import br.com.senior.mydomain.myservice.PecaEntity;
import br.com.senior.mydomain.myservice.StatusPeca;

import java.time.LocalDateTime;
import java.util.List;

public interface PecaRepositoryCustom {
    List<PecaEntity> getPecasPendentes(StatusPeca status);

    Long countPecaMorta(LocalDateTime inicio, LocalDateTime fim, List<String> desenhos);
}