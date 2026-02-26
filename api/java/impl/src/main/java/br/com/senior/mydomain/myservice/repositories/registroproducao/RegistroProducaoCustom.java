package br.com.senior.mydomain.myservice.repositories.registroproducao;

import br.com.senior.mydomain.myservice.PecaFuncionario;
import br.com.senior.mydomain.myservice.RecordRegistroProducao;
import br.com.senior.mydomain.myservice.RegistroProducao;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistroProducaoCustom {
    List<RecordRegistroProducao> findAllCompleto();

    List<PecaFuncionario> pecaPorFuncionario(LocalDateTime inicio, LocalDateTime fim, List<String> funcionarios, String turno);
}
