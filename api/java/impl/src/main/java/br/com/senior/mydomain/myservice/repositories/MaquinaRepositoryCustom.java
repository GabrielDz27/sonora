package br.com.senior.mydomain.myservice.repositories;

import br.com.senior.mydomain.myservice.MaquinaEntity;

import java.util.List;

public interface MaquinaRepositoryCustom {
    List<MaquinaEntity> getMaquinasStatusAtivas();
}
