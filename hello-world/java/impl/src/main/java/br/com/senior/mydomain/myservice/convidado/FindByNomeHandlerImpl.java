package br.com.senior.mydomain.myservice.convidado;

import br.com.senior.mydomain.myservice.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindByNomeHandlerImpl implements FindByNome {

    @Inject
    private ConvidadoRepository repository;

    @Override
    public FindByNomeOutput findByNome(FindByNomeInput request) {
        final List<ConvidadoEntity> convidados = repository.findByNomeContainingIgnoreCase(request.nome);

        final List<Convidado> convidadosDto = convidados
                .stream()
                .map(convidadoEntity ->
                        new Convidado(
                                convidadoEntity.getId().toString(),
                                convidadoEntity.getNome().toString(),
                                convidadoEntity.getNomeSocial().toString(),
                                convidadoEntity.getCpf().toString(),
                                convidadoEntity.getDataNascimento(),
                                null
                        )
                ).collect(Collectors.toList());
        return new FindByNomeOutput(convidadosDto);
    }
}
