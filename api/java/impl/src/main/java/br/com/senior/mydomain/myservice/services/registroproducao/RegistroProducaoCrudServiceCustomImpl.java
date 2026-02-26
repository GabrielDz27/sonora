package br.com.senior.mydomain.myservice.services.registroproducao;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Primary
public class RegistroProducaoCrudServiceCustomImpl extends RegistroProducaoCrudServiceImpl {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private PecaRepository pecaRepository;

    @Inject
    private TranslationHubApi translationHubApi;

    @Autowired(required = false)
    private RegistroProducaoCrudValidator validator;

    private boolean hasValidator() {
        return validator != null;
    }

    @Override
    public RegistroProducaoEntity createRegistroProducao(RegistroProducaoEntity entity) {

        pecaRepository.updateStatusById(StatusPeca.PROCESSO, entity.getPeca().getId());
        System.out.println("RegistroProducaoCrudServiceCustomImpl createRegistroProducao"+entity);
        prepareSession();
        try {
            if (hasValidator()) {
                validator.beforeCreate(entity);
            }
            return super.repository.saveAndFlush(entity);
        } catch (DataIntegrityViolationException | org.springframework.dao.InvalidDataAccessApiUsageException ex) {
            if(ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                org.hibernate.exception.ConstraintViolationException cve = (org.hibernate.exception.ConstraintViolationException) ex.getCause();
                if(!("my_domain.my_service.create_entity_constraint_violation_" + cve.getConstraintName()).equals(translationHubApi.getFormattedMessage("my_domain.my_service.create_entity_constraint_violation_" + cve.getConstraintName()))) {
                    throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getFormattedMessage("my_domain.my_service.create_entity_constraint_violation_" + cve.getConstraintName()));
                }
                throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getFormattedMessage("my_domain.my_service.create_entity_constraint_violation", cve.getConstraintName()));
            }

            if(ex.getCause() instanceof IllegalStateException) {
                throw new ServiceException(ErrorCategory.BAD_REQUEST, translationHubApi.getFormattedMessage("my_domain.my_service.create_entity_transient", ex.getMessage()));
            }

            throw new ServiceException(ErrorCategory.CONFLICT, translationHubApi.getMessage("my_domain.my_service.registroProducaoEntity_dataIntegrityViolation", "Data integrity violation to Create RegistroProducaoEntity. Error: " + ex.getMessage()));
        }
    }
}
