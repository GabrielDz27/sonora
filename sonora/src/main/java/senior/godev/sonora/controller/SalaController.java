package senior.godev.sonora.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import senior.godev.sonora.models.sala.DadosAtualizacaoSala;
import senior.godev.sonora.models.sala.DadosCadastroSala;
import senior.godev.sonora.models.sala.DadosDetalhamentoSala;
import senior.godev.sonora.models.sala.Sala;
import senior.godev.sonora.repository.SalaRepository;

@RestController
@RequestMapping("/sala")
class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    /**
     * @Endpoints Alguns endpoints são feitos somente para administradores manipular
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

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoSala dados) {
        var sala = salaRepository.getReferenceById(dados.id());
        sala.atualizarSala(dados);

        return ResponseEntity.ok(new DadosDetalhamentoSala(sala));
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var sala = salaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrado"));

        try {
            salaRepository.delete(sala);

            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(409).build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var sala = salaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoSala(sala));
    }

}
