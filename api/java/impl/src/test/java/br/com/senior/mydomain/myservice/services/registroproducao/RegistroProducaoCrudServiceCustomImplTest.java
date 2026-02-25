package br.com.senior.mydomain.myservice.services.registroproducao;

import static org.junit.jupiter.api.Assertions.*;

import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class RegistroProducaoCrudServiceCustomImplTest {

    @Spy
    @InjectMocks
    private RegistroProducaoCrudServiceCustomImpl service;

    @Mock
    private PecaRepository pecaRepository;

    @Mock
    private RegistroProducaoEntity entity;

    @Mock
    private PecaEntity peca;

    private UUID id = UUID.randomUUID();

    @Test
    public void deveAtualizarStatusPecaAntesDeCriar() {
        when(entity.getPeca()).thenReturn(peca);
        when(peca.getId()).thenReturn(id);

        RegistroProducaoEntity retornoSuper = mock(RegistroProducaoEntity.class);
        doReturn(retornoSuper).when(service).create(entity);

        RegistroProducaoEntity result = service.create(entity);

        verify(pecaRepository).updateStatusById(StatusPeca.PROCESSO, id);
        assertEquals(retornoSuper, result);
    }

    @Test
    public void deveChamarSuperNoUpdate() {
        RegistroProducaoEntity retornoSuper = mock(RegistroProducaoEntity.class);
        doReturn(retornoSuper).when(service).updateRegistroProducao(entity);

        RegistroProducaoEntity result = service.updateRegistroProducao(entity);

        assertEquals(retornoSuper, result);
    }
}