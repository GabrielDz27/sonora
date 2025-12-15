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
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.instrumento.formatacao.*;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.repository.InstrumentoRepository;

import java.util.Optional;

@RestController
@RequestMapping("/instrumento")
class InstrumentoController {

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    /**
     * @Instrumentos
     * @Endpoints Alguns endpoints são feitos somente para administradores manipular
     * Cadastrar
     */
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroInstrumento dados, UriComponentsBuilder uriBuilder) {
        var instrumento = new Instrumento(dados);
        instrumentoRepository.save(instrumento);

        var uri = uriBuilder.path("instrumento/{id}").buildAndExpand(instrumento.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoInstrumento(instrumento));
    }

    /**
     * @Instrumentos Atualizar o registro do instrumento
     */
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoInstrumento dados) {
        var instrumento = instrumentoRepository.getReferenceById(dados.id());
        instrumento.atualizarInstrumento(dados);

        return ResponseEntity.ok(new DadosDetalhamentoInstrumento(instrumento));
    }

    /**
     * @Instrumentos Deletar o registro da instrumento
     */
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Optional<Instrumento> instrumento = instrumentoRepository.findById(id);

        if (instrumento.isEmpty()) {
            throw new EntityNotFoundException("Sala não encontrado");
        }

        try {
            for (Reserva reserva : instrumentoRepository.findAllReservaById(instrumento.get().getId())) {
                instrumento.get().removerReserva(reserva);
            }
            instrumentoRepository.deleteById(instrumento.get().getId());

            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(409).build();
        }
    }

    /**
     * @Instrumentos Listar pelo id da instrumento
     */
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var instrumento = instrumentoRepository.findAllById(id);

        return ResponseEntity.ok(new DadosDetalhamentoInstrumento(instrumento));
    }

    /**
     * @Instrumentos Listar todas as instrumentos
     */
    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrumento>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = instrumentoRepository.findAll(paginacao).map(DadosListagemInstrumento::new);
        return ResponseEntity.ok(page);
    }

    /**
     * @Instrumentos
     * @Reservas Quando for pesquisar o instrumento para reservar, precisa aparecer se estar reservado ou não, dando dado mais coeso, com true e false;
     */
    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoInstrumentoEReserva>> listarInstrumentoReserva(@RequestBody DadosListagemInstrumentoReserva dadosListagemInstrumentoReserva) {
        var page = instrumentoRepository.findAllAndReserva(
                dadosListagemInstrumentoReserva.paginacao(),
                dadosListagemInstrumentoReserva.dataHoraInicio(),
                dadosListagemInstrumentoReserva.dataHoraFinal()
        ).map(DadosDetalhamentoInstrumentoEReserva::new);
        return ResponseEntity.ok(page);
    }
}
