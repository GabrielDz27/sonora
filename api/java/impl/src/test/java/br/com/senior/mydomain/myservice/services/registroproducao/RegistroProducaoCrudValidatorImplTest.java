package br.com.senior.mydomain.myservice.services.registroproducao;

import static org.junit.jupiter.api.Assertions.*;

import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.repositories.maquina.MaquinaRepository;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import br.com.senior.mydomain.myservice.repositories.registroproducao.RegistroProducaoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class RegistroProducaoCrudValidatorImplTest {

    private RegistroProducaoCrudValidatorImpl validator;

    private MaquinaRepository maquinaRepo;
    private PecaRepository pecaRepo;
    private RegistroProducaoRepository registroRepo;

    private RegistroProducaoEntity entity;
    private PecaEntity peca;
    private MaquinaEntity maquina;

    private UUID idPeca = UUID.randomUUID();
    private UUID idMaquina = UUID.randomUUID();

    @Before
    public void setup() throws Exception {
        validator = new RegistroProducaoCrudValidatorImpl();

        maquinaRepo = mock(MaquinaRepository.class);
        pecaRepo = mock(PecaRepository.class);
        registroRepo = mock(RegistroProducaoRepository.class);

        setStatic("maquinaRepository", maquinaRepo);
        setStatic("pecaRepository", pecaRepo);
        setStatic("registroProducaoRepository", registroRepo);

        entity = mock(RegistroProducaoEntity.class);
        peca = mock(PecaEntity.class);
        maquina = mock(MaquinaEntity.class);

        when(entity.getPeca()).thenReturn(peca);
        when(entity.getMaquina()).thenReturn(maquina);
        when(peca.getId()).thenReturn(idPeca);
        when(maquina.getId()).thenReturn(idMaquina);

        when(pecaRepo.isPecaStatusNotPendente(idPeca)).thenReturn(false);
        when(maquinaRepo.isMaquinaStatusNotAtiva(idMaquina)).thenReturn(false);
        when(registroRepo.isMaquinaUsada(any(LocalDateTime.class), eq(idMaquina))).thenReturn(false);
    }

    private void setStatic(String fieldName, Object value) throws Exception {
        Field field = RegistroProducaoCrudValidatorImpl.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(null, value);
    }

    @Test
    public void devePassarValidacaoBeforeCreate() {
        validator.beforeCreate(entity);
    }

    @Test
    public void devePassarValidacaoBeforeUpdate() {
        validator.beforeUpdate(entity);
    }

    @Test(expected = ServiceException.class)
    public void deveFalharQuandoPecaNaoDisponivel() {
        when(pecaRepo.isPecaStatusNotPendente(idPeca)).thenReturn(true);
        validator.beforeCreate(entity);
    }

    @Test(expected = ServiceException.class)
    public void deveFalharQuandoMaquinaInativa() {
        when(maquinaRepo.isMaquinaStatusNotAtiva(idMaquina)).thenReturn(true);
        validator.beforeCreate(entity);
    }

    @Test(expected = ServiceException.class)
    public void deveFalharQuandoMaquinaEmUso() {
        when(registroRepo.isMaquinaUsada(any(LocalDateTime.class), eq(idMaquina))).thenReturn(true);
        validator.beforeCreate(entity);
    }

    @Test
    public void beforeDeleteNaoDeveFazerNada() {
        RegistroProducao.Id id = mock(RegistroProducao.Id.class);
        validator.beforeDelete(id);
    }
}