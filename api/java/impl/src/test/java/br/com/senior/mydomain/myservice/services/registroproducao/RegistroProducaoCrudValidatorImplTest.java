package br.com.senior.mydomain.myservice.services.registroproducao;

import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.repositories.maquina.MaquinaRepository;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import br.com.senior.mydomain.myservice.repositories.registroproducao.RegistroProducaoRepository;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegistroProducaoCrudValidatorImplTest {

    @InjectMocks
    private RegistroProducaoCrudValidatorImpl validator;

    @Mock
    private MaquinaRepository maquinaRepository;

    @Mock
    private PecaRepository pecaRepository;

    @Mock
    private RegistroProducaoRepository registroProducaoRepository;

    @Mock
    private TranslationHubApi translationHubApi;

    @Mock
    private RegistroProducaoEntity entity;

    @Mock
    private PecaEntity peca;

    @Mock
    private MaquinaEntity maquina;

    private UUID idPeca;
    private UUID idMaquina;

    @Before
    public void setup() {

        idPeca = UUID.randomUUID();
        idMaquina = UUID.randomUUID();

        when(entity.getPeca()).thenReturn(peca);
        when(entity.getMaquina()).thenReturn(maquina);
        when(peca.getId()).thenReturn(idPeca);
        when(maquina.getId()).thenReturn(idMaquina);

        when(translationHubApi.getMessage(anyString())).thenReturn("erro");

        when(pecaRepository.isPecaStatusNotPendente(idPeca)).thenReturn(false);
        when(maquinaRepository.isMaquinaStatusNotAtiva(idMaquina)).thenReturn(false);
        when(registroProducaoRepository.isMaquinaUsada(any(LocalDateTime.class), eq(idMaquina)))
                .thenReturn(false);
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
        when(pecaRepository.isPecaStatusNotPendente(idPeca)).thenReturn(true);
        validator.beforeCreate(entity);
    }

    @Test(expected = ServiceException.class)
    public void deveFalharQuandoMaquinaInativa() {
        when(maquinaRepository.isMaquinaStatusNotAtiva(idMaquina)).thenReturn(true);
        validator.beforeCreate(entity);
    }

    @Test(expected = ServiceException.class)
    public void deveFalharQuandoMaquinaEmUso() {
        when(registroProducaoRepository.isMaquinaUsada(any(LocalDateTime.class), eq(idMaquina)))
                .thenReturn(true);

        validator.beforeCreate(entity);
    }

    @Test
    public void beforeDeleteNaoDeveFazerNada() {
        RegistroProducao.Id id = mock(RegistroProducao.Id.class);
        validator.beforeDelete(id);

        verifyNoInteractions(
                maquinaRepository,
                pecaRepository,
                registroProducaoRepository
        );
    }
}