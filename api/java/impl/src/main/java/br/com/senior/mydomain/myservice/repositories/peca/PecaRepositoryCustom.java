package br.com.senior.mydomain.myservice.repositories.peca;

import br.com.senior.mydomain.myservice.PecaEntity;

import java.util.List;

public interface PecaRepositoryCustom {
    List<PecaEntity> getPecasPendentes();
}