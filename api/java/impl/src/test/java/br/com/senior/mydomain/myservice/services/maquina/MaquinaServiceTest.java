package br.com.senior.mydomain.myservice.services.maquina;

import br.com.senior.mydomain.myservice.MaquinaEntity;
import br.com.senior.mydomain.myservice.repositories.maquina.MaquinaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class MaquinaServiceTest {

    @InjectMocks
    private MaquinaService service;

    @Mock
    private MaquinaRepository repository;

    @Test
    public void deveRetornarListaDeMaquinasAtivas() {
        List<MaquinaEntity> listaMock = Arrays.asList(
                mock(MaquinaEntity.class),
                mock(MaquinaEntity.class)
        );

        when(repository.getMaquinasStatusAtivas()).thenReturn(listaMock);

        List<MaquinaEntity> resultado = service.getMaquinasStatusAtivas();

        assertEquals(listaMock, resultado);
        verify(repository, times(1)).getMaquinasStatusAtivas();
        verifyNoMoreInteractions(repository);
    }
}