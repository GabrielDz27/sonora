package br.com.senior.mydomain.myservice.handler.maquina;

import br.com.senior.mydomain.myservice.*;
import br.com.senior.mydomain.myservice.services.maquina.MaquinaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class GetMaquinaAtivaHandlerImplTest {

    @InjectMocks
    private GetMaquinaAtivaHandlerImpl handler;

    @Mock
    private MaquinaService service;

    @Mock
    private MaquinaEntity entity;

    @Test
    public void deveRetornarListaConvertidaDeMaquinas() {
        UUID id = UUID.randomUUID();

        when(service.getMaquinasStatusAtivas()).thenReturn(Arrays.asList(entity));
        when(entity.getId()).thenReturn(id);
        when(entity.getNome()).thenReturn("Maquina 1");
        when(entity.getStatus()).thenReturn(StatusMaquina.ATIVO);

        GetMaquinaAtivaOutput output = handler.getMaquinaAtiva();

        assertNotNull(output);
        assertNotNull(output.maquina);
        assertEquals(1, output.maquina.size());

        Maquina maquina = output.maquina.get(0);
        assertEquals(id.toString(), maquina.id);
        assertEquals("Maquina 1", maquina.nome);
        assertEquals(StatusMaquina.ATIVO, maquina.status);
//        assertNull(maquina.outro); // campo null do construtor

        verify(service).getMaquinasStatusAtivas();
        verifyNoMoreInteractions(service);
    }
}