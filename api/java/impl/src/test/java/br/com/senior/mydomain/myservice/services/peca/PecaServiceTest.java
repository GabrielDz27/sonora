package br.com.senior.mydomain.myservice.services.peca;

import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.PecaEntity;
import br.com.senior.mydomain.myservice.RetornoAtualizarStatus;
import br.com.senior.mydomain.myservice.StatusPeca;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PecaServiceTest {

    @InjectMocks
    private PecaService service;

    @Mock
    private PecaRepository repository;

    @Mock
    private TranslationHubApi translation;

    @Mock
    private PecaEntity entity;

    private final UUID uuid = UUID.randomUUID();

    @Test
    public void deveAtualizarStatusComSucesso() {
        when(repository.findById(uuid)).thenReturn(Optional.of(entity));
        when(entity.getId()).thenReturn(uuid);
        when(translation.getMessage(anyString())).thenReturn("sucesso");

        RetornoAtualizarStatus retorno =
                service.atualizarStatus(uuid.toString(), StatusPeca.PROCESSO);

        assertNotNull(retorno);

        verify(repository).updateStatusById(StatusPeca.PROCESSO, uuid);
        verify(repository).findById(uuid);
        verify(translation).getMessage("br.com.senior.my_domain.my_service.mensagemRetornoSucesso");
        verifyNoMoreInteractions(repository, translation);
    }

    @Test
    public void deveLancarExcecaoQuandoIdNaoEncontrado() {
        when(repository.findById(uuid)).thenReturn(Optional.empty());
        when(translation.getMessage(anyString())).thenReturn("erro");

        try {
            service.atualizarStatus(uuid.toString(), StatusPeca.PROCESSO);
            fail("Deveria lançar ServiceException");
        } catch (ServiceException e) {
            assertEquals("erro", e.getMessage());
        }

        verify(repository).updateStatusById(StatusPeca.PROCESSO, uuid);
        verify(repository).findById(uuid);
        verify(translation).getMessage("br.com.senior.my_domain.my_service.mensagemRetornoIdInvalido");
        verifyNoMoreInteractions(repository, translation);
    }

    @Test
    public void deveRetornarPecasPendentes() {
        List<PecaEntity> lista = Arrays.asList(mock(PecaEntity.class));
        when(repository.getPecasPendentes(StatusPeca.PENDENTE)).thenReturn(lista);

        List<PecaEntity> result = service.getPecasPendentes(StatusPeca.PENDENTE);

        assertEquals(lista, result);
        verify(repository).getPecasPendentes(StatusPeca.PENDENTE);
        verifyNoMoreInteractions(repository);
    }
}