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
import senior.godev.sonora.exceptions.ValidacaoException;
import senior.godev.sonora.models.instrumento.Instrumento;
import senior.godev.sonora.models.instrumento.dto.*;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.repository.InstrumentoRepository;
import senior.godev.sonora.repository.SalaRepository;

import java.util.Optional;

@RestController
@RequestMapping("/instrumentos")
class InstrumentoController {

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @Autowired
    private SalaRepository salaRepository;

    /**
     * @Instrumentos
     * @Endpoints Alguns endpoints são feitos somente para administradores manipular
     * Cadastrar
     */
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroInstrumento dados, UriComponentsBuilder uriBuilder) {
        if (!salaRepository.existsById(dados.idSala())) {
            throw new ValidacaoException("O id da sala não existe");
        }

        var sala = salaRepository.getReferenceById(dados.idSala());
        var instrumento = new Instrumento(dados, sala);
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
        if (!salaRepository.existsById(dados.idSala())) {
            throw new ValidacaoException("O id da sala não existe");
        }

        var instrumento = instrumentoRepository.getReferenceById(dados.id());
        var sala = salaRepository.getReferenceById(dados.idSala());

        if (instrumento.getSala_fixa_id() != sala) {
            sala.atualizaInstrumento(instrumento);
        }

        instrumento.atualizarInstrumento(dados, sala);

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
    @GetMapping("/reservas")
    public ResponseEntity<Page<DadosDetalhamentoInstrumentoEReserva>> listarInstrumentoReserva(@RequestBody DadosListagemInstrumentoReserva dadosListagemInstrumentoReserva, @PageableDefault(size = 20, sort = {"id"}) Pageable paginacao) {
        var page = instrumentoRepository.findAllAndReserva(
                paginacao,
                dadosListagemInstrumentoReserva.dataHoraInicio(),
                dadosListagemInstrumentoReserva.dataHoraFinal()
        ).map(DadosDetalhamentoInstrumentoEReserva::new);
        return ResponseEntity.ok(page);
    }
}
