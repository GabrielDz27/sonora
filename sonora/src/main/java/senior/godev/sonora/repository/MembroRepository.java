package senior.godev.sonora.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import senior.godev.sonora.models.membro.Membro;
import senior.godev.sonora.models.membro.formatacao.DadosListagemMembro;

public interface MembroRepository extends JpaRepository<Membro, Long> {
    Membro findAllById(Long id);

    @Query("""
            SELECT NEW senior.godev.sonora.models.membro.formatacao.DadosListagemMembro(
                m.id,
                u.login,
                m.cpf,
                m.nome,
                m.email)
            FROM Membro m
            JOIN Usuario u
            WHERE m.ativo = true
            """)
    Page<DadosListagemMembro> findAllDetalhamentoListagem(Pageable paginacao);
}