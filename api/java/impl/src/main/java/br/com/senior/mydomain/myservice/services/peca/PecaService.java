package br.com.senior.mydomain.myservice.services.peca;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.PecaEntity;
import br.com.senior.mydomain.myservice.RetornoAtualizarStatus;
import br.com.senior.mydomain.myservice.StatusPeca;
import br.com.senior.mydomain.myservice.repositories.PecaRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Service
public class PecaService {

    @Inject
    private PecaRepository pecaRepository;

    @Transactional
    public RetornoAtualizarStatus atualizarStatus(String id, StatusPeca status) {
        pecaRepository.updateStatusById(status, UUID.fromString(id));

        final Optional<PecaEntity> convidadoOpt = pecaRepository.findById(UUID.fromString(id));
        if (convidadoOpt.isPresent()) {
            return new RetornoAtualizarStatus(
                    "sucesso",
                    String.valueOf(convidadoOpt.get().getId()),
                    false
            );
        } else {
            throw new ServiceException(ErrorCategory.BAD_REQUEST, "Id inválido");
        }

    }
}
