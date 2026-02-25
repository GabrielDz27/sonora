package br.com.senior.mydomain.myservice.services.funcionario;

import br.com.senior.mydomain.myservice.Funcionario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import static org.mockito.Mockito.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class FuncionanrioCrudServiceCustomImplTest {

    @InjectMocks
    private FuncionanrioCrudServiceCustomImpl service;

    @Mock
    private FuncionarioService funcionarioService;

    @Mock
    private Funcionario.Id id;

    @Test
    public void deveChamarServiceAoDeletarFuncionario() {
        service.deleteFuncionario(id);

        verify(funcionarioService, times(1)).desativarFuncioario(id);
        verifyNoMoreInteractions(funcionarioService);
    }
}