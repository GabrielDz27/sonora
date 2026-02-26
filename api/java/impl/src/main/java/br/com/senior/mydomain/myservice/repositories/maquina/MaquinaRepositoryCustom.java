package br.com.senior.mydomain.myservice.repositories.maquina;

import br.com.senior.mydomain.myservice.MaquinaEntity;
import br.com.senior.mydomain.myservice.MaquinaTrabalhando;

import java.time.LocalDateTime;
import java.util.List;

public interface MaquinaRepositoryCustom {
    List<MaquinaEntity> getMaquinasStatusAtivas();
    List<MaquinaTrabalhando> maquinaTrabalhada(LocalDateTime inicio, LocalDateTime fim, List<String> maquinas);
}
