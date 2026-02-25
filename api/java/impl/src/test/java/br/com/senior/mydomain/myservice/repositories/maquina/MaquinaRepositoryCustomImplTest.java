package br.com.senior.mydomain.myservice.repositories.maquina;

import static org.junit.jupiter.api.Assertions.*;

import br.com.senior.mydomain.myservice.MaquinaEntity;
import com.querydsl.jpa.impl.JPAQuery;
import org.junit.Test;
import org.mockito.MockedConstruction;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MaquinaRepositoryCustomImplTest {

    @Test
    public void deveBuscarMaquinasAtivas() throws Exception {

        EntityManager emMock = mock(EntityManager.class);
        MaquinaRepositoryCustomImpl repo = new MaquinaRepositoryCustomImpl();

        Field field = MaquinaRepositoryCustomImpl.class.getDeclaredField("em");
        field.setAccessible(true);
        field.set(repo, emMock);

        List<MaquinaEntity> lista = Arrays.asList(mock(MaquinaEntity.class));

        try (MockedConstruction<JPAQuery> mocked = mockConstruction(JPAQuery.class,
                (mock, context) -> {
                    when(mock.select(any())).thenReturn(mock);
                    when(mock.from(any())).thenReturn(mock);
                    when(mock.where(any())).thenReturn(mock);
                    when(mock.fetch()).thenReturn(lista);
                })) {

            List<MaquinaEntity> result = repo.getMaquinasStatusAtivas();

            assertEquals(lista, result);

            JPAQuery constructed = mocked.constructed().get(0);
            verify(constructed).select(any());
            verify(constructed).from(any());
            verify(constructed).where(any());
            verify(constructed).fetch();
        }
    }
}