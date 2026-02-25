package br.com.senior.mydomain.myservice.services.funcionario;

import br.com.senior.mydomain.myservice.Funcionario;
import br.com.senior.mydomain.myservice.FuncionarioEntity;
import br.com.senior.mydomain.myservice.repositories.funcionario.FuncionarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class FuncionarioServiceTest {

    @InjectMocks
    private FuncionarioService service;

    @Mock
    private FuncionarioRepository repository;

    @Mock
    private Funcionario.Id idMock;

    private UUID uuid;

    @Before
    public void setup() {
        uuid = UUID.randomUUID();
        when(idMock.toString()).thenReturn(uuid.toString());
    }

    @Test
    public void deveDesativarFuncionario() {
        service.desativarFuncioario(idMock);

        verify(repository, times(1)).desativar(uuid);
    }

    @Test
    public void deveBuscarFuncionarioPorUsername() {
        String username = "gabriel";
        FuncionarioEntity entity = mock(FuncionarioEntity.class);

        when(repository.findFuncionarioByUsername(username)).thenReturn(entity);

        FuncionarioEntity result = service.findFuncionanrioByUsername(username);

        assertEquals(entity, result);
        verify(repository, times(1)).findFuncionarioByUsername(username);
    }
}