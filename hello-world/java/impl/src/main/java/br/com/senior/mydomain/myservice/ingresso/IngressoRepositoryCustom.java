package br.com.senior.mydomain.myservice.ingresso;

import br.com.senior.mydomain.myservice.IngressoEntity;

import java.util.List;
import java.util.UUID;

public interface IngressoRepositoryCustom {

    List<UUID> getIdsByConvidadoNome(String nome);


}
