package br.com.senior.mydomain.myservice.services.maquina;

import br.com.senior.mydomain.myservice.MaquinaEntity;
import br.com.senior.mydomain.myservice.repositories.maquina.MaquinaRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MaquinaService {

    @Inject
    private MaquinaRepository maquinaRepository;

    public List<MaquinaEntity> getMaquinasStatusAtivas() {
        return maquinaRepository.getMaquinasStatusAtivas();
    }
}
