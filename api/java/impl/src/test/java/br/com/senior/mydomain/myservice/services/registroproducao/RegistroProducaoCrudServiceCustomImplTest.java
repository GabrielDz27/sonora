package br.com.senior.mydomain.myservice.services.registroproducao;

import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.repositories.peca.PecaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
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

        // impede execução real da superclasse
        doReturn(retornoSuper)
                .when((RegistroProducaoCrudServiceImpl) service)
                .create(entity);

        RegistroProducaoEntity result = service.createRegistroProducao(entity);

        verify(pecaRepository).updateStatusById(StatusPeca.PROCESSO, id);
        assertEquals(retornoSuper, result);
    }
}