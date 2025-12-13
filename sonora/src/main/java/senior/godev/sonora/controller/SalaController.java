package senior.godev.sonora.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.models.sala.formatacao.DadosAtualizacaoSala;
import senior.godev.sonora.models.sala.formatacao.DadosCadastroSala;
import senior.godev.sonora.models.sala.formatacao.DadosDetalhamentoCompletoSala;
import senior.godev.sonora.models.sala.formatacao.DadosDetalhamentoSala;
import senior.godev.sonora.repository.SalaRepository;
import senior.godev.sonora.repository.projections.SalaProjection;

import java.util.Optional;

@RestController
@RequestMapping("/sala")
class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    /**
     * @Salas
     * @Endpoints Alguns endpoints são feitos somente para administradores manipular
     * Cadastrar
     */
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroSala dados, UriComponentsBuilder uriBuilder) {
        var sala = new Sala(dados);
        salaRepository.save(sala);

        var uri = uriBuilder.path("sala/{id}").buildAndExpand(sala.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoSala(sala));
    }

    /**
     * @Salas Atualizar o registro da sala
     */
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoSala dados) {
        var sala = salaRepository.getReferenceById(dados.id());
        sala.atualizarSala(dados);

        return ResponseEntity.ok(new DadosDetalhamentoSala(sala));
    }

    /**
     * @Salas Deletar o registro da sala
     */
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Optional<Sala> sala = salaRepository.findById(id);

        if (sala.isEmpty()) {
            throw new EntityNotFoundException("Sala não encontrado");
        }

        try {
            for (Reserva reserva : salaRepository.findAllReservaById(sala.get().getId())) {
                sala.get().removerReserva(reserva);
            }
            salaRepository.deleteById(sala.get().getId());

            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(409).build();
        }
    }

    /**
     * @Salas Listar pelo id da sala
     */
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Optional<SalaProjection> salaProjectionO = salaRepository.findAllAndInstrumentoById(id);

        if (salaProjectionO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        SalaProjection salaProjection = salaProjectionO.get();

        var sala = new Sala();
        sala.setId(salaProjection.getId());
        sala.setNome(salaProjection.getNome());
        sala.setCapacidade(salaProjection.getCapacidade());
        sala.setTem_abafadores(salaProjection.getTem_Abafadores());

        return ResponseEntity.ok(new DadosDetalhamentoCompletoSala(
                sala,
                salaProjection.getQuantidadeInstrumentos(),
                salaProjection.getNomesInstrumentos()));
    }

    /**
     * @Salas Listar todas as salas
     */
    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoSala>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = salaRepository.findAll(paginacao).map(DadosDetalhamentoSala::new);
        return ResponseEntity.ok(page);
    }
}
