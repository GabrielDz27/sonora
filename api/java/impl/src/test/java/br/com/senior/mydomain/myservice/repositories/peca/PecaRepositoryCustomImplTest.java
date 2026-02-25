package br.com.senior.mydomain.myservice.repositories.peca;

import br.com.senior.mydomain.myservice.PecaEntity;
import br.com.senior.mydomain.myservice.StatusPeca;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import org.junit.Test;
import org.mockito.MockedConstruction;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PecaRepositoryCustomImplTest {

    @Test
    public void deveBuscarPecasPendentes() throws Exception {

        EntityManager emMock = mock(EntityManager.class);
        PecaRepositoryCustomImpl repo = new PecaRepositoryCustomImpl();

        Field field = PecaRepositoryCustomImpl.class.getDeclaredField("em");
        field.setAccessible(true);
        field.set(repo, emMock);

        List<PecaEntity> lista = Arrays.asList(mock(PecaEntity.class));

        try (MockedConstruction<JPAQuery> mocked = mockConstruction(JPAQuery.class,
                (mock, context) -> {
                    when(mock.select((Expression) any())).thenReturn(mock);
                    when(mock.from((EntityPath<?>) any())).thenReturn(mock);
                    when(mock.where((Predicate) any())).thenReturn(mock);
                    when(mock.fetch()).thenReturn(lista);
                })) {

            List<PecaEntity> result = repo.getPecasPendentes(StatusPeca.PENDENTE);

            assertEquals(lista, result);

            JPAQuery constructed = mocked.constructed().get(0);
            verify(constructed).select((Expression) any());
            verify(constructed).from((EntityPath<?>) any());
            verify(constructed).where((Predicate) any());
            verify(constructed).fetch();
        }
    }
}