package br.com.senior.mydomain.myservice.repositories.maquina;

import br.com.senior.mydomain.myservice.MaquinaEntity;
import br.com.senior.mydomain.myservice.MaquinaTrabalhando;
import br.com.senior.mydomain.myservice.QMaquinaEntity;
import br.com.senior.mydomain.myservice.QRegistroProducaoEntity;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.CollectionExpression;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import org.junit.Test;
import org.mockito.MockedConstruction;
import org.springframework.test.util.ReflectionTestUtils;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
                    when(mock.select((Expression) any())).thenReturn(mock);
                    when(mock.from((EntityPath<?>) any())).thenReturn(mock);
                    when(mock.where((Predicate) any())).thenReturn(mock);
                    when(mock.fetch()).thenReturn(lista);
                })) {

            List<MaquinaEntity> result = repo.getMaquinasStatusAtivas();

            assertEquals(lista, result);

            JPAQuery constructed = mocked.constructed().get(0);
            verify(constructed).select((Expression) any());
            verify(constructed).from((EntityPath<?>) any());
            verify(constructed).where((Predicate) any());
            verify(constructed).fetch();
        }
    }
//
//    @Test
//    public void deveRetornarHorasAgrupadasPorMaquina() {
//
//        EntityManager emMock = mock(EntityManager.class);
//        MaquinaRepositoryCustomImpl repo = new MaquinaRepositoryCustomImpl();
//        ReflectionTestUtils.setField(repo, "em", emMock);
//
//        Tuple tuple = mock(Tuple.class);
//
//        UUID id = UUID.randomUUID();
//
//        try (MockedConstruction<JPAQuery> mocked =
//                     mockConstruction(JPAQuery.class, (mock, context) -> {
//
//                         when(mock.select(any(Expression.class), any(Expression.class),
//                                 any(Expression.class), any(Expression.class)))
//                                 .thenReturn(mock);
//
//                         when(mock.from((EntityPath<?>) any())).thenReturn(mock);
//                         when(mock.join((CollectionExpression) any(), any())).thenReturn(mock);
//                         when(mock.where((Predicate) any())).thenReturn(mock);
//
//                         when(mock.fetch()).thenReturn(List.of(tuple));
//                     })) {
//
//            // mock dos campos do tuple
//            when(tuple.get(any(Expression.class))).thenReturn(null);
//
//            QRegistroProducaoEntity r = QRegistroProducaoEntity.registroProducaoEntity;
//            QMaquinaEntity m = QMaquinaEntity.maquinaEntity;
//
//            when(tuple.get(m.id)).thenReturn(id);
//            when(tuple.get(m.nome)).thenReturn("Máquina Teste");
//            when(tuple.get(r.dataInicio)).thenReturn(Instant.now().minusSeconds(7200));
//            when(tuple.get(r.dataFinal)).thenReturn(Instant.now());
//
//            List<MaquinaTrabalhando> result =
//                    repo.maquinaTrabalhada(null, null, null);
//
//            assertEquals(1, result.size());
//            assertEquals("Máquina Teste", result.get(0).maquina.nome);
//        }
//    }
}