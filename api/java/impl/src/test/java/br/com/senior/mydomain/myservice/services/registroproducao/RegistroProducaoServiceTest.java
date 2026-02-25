package br.com.senior.mydomain.myservice.services.registroproducao;

import static org.junit.jupiter.api.Assertions.*;

import br.com.senior.messaging.model.ServiceException;
import br.com.senior.mydomain.myservice.RegistroProducaoEntity;
import br.com.senior.mydomain.myservice.RetornoAtualizarStatus;
import br.com.senior.mydomain.myservice.repositories.registroproducao.RegistroProducaoRepository;
import br.com.senior.platform.translationhub.api.TranslationHubApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class RegistroProducaoServiceTest {

    @InjectMocks
    private RegistroProducaoService service;

    @Mock
    private RegistroProducaoRepository repository;

    @Mock
    private TranslationHubApi translation;

    @Mock
    private RegistroProducaoEntity entity;

    private final UUID uuid = UUID.randomUUID();

    @Test
    public void deveFinalizarComSucesso() {
        when(repository.findById(uuid)).thenReturn(Optional.of(entity));
        when(entity.getId()).thenReturn(uuid);
        when(translation.getMessage(anyString())).thenReturn("sucesso");

        RetornoAtualizarStatus retorno = service.finalizar(uuid.toString());

        assertNotNull(retorno);

        verify(repository).updateStatusById(any(LocalDateTime.class), eq(uuid));
        verify(repository).findById(uuid);
        verify(translation).getMessage("br.com.senior.my_domain.my_service.mensagemRetornoSucesso");
        verifyNoMoreInteractions(repository, translation);
    }

    @Test
    public void deveLancarExcecaoQuandoNaoEncontrarRegistro() {
        when(repository.findById(uuid)).thenReturn(Optional.empty());
        when(translation.getMessage(anyString())).thenReturn("erro");

        try {
            service.finalizar(uuid.toString());
            fail("Deveria lançar ServiceException");
        } catch (ServiceException e) {
            assertEquals("erro", e.getMessage());
        }

        verify(repository).updateStatusById(any(LocalDateTime.class), eq(uuid));
        verify(repository).findById(uuid);
        verify(translation).getMessage("br.com.senior.my_domain.my_service.mensagemRetornoIdInvalido");
        verifyNoMoreInteractions(repository, translation);
    }
}