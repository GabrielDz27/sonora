package senior.godev.sonora.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import senior.godev.sonora.models.membro.dto.DadosAtualizacaoMembro;
import senior.godev.sonora.models.membro.dto.DadosCadastroMembro;
import senior.godev.sonora.models.membro.dto.DadosDetalhamentoMembro;
import senior.godev.sonora.models.membro.dto.DadosListagemMembro;
import senior.godev.sonora.service.MembroService;

@RestController
@RequestMapping("/membros")
class MembroController {

    @Autowired
    private MembroService membroService;

    /**
     * @Endpoints
     * @Membros Cadastro de membro é muito importante, mas tudo tem que ser feito pelo administrador,
     * pois tem que respeitar a lei LGPD
     */
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMembro dados, UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoMembro detalhamentoMembro = membroService.cadastrar(dados);

        var uri = uriBuilder.path("membro/{id}").buildAndExpand(detalhamentoMembro.id()).toUri();

        return ResponseEntity.created(uri).body(detalhamentoMembro);
    }

    /**
     * @Membros Atualizar o registro do membro
     */
    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMembro dados) {

        return ResponseEntity.ok(membroService.atualizarMembro(dados));
    }

    /**
     * @Membros Listar pelo id do membro
     */
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(membroService.detalharMembro(id));
    }

    /**
     * @Membros Listar todos os membros
     */
    @GetMapping
    public ResponseEntity<Page<DadosListagemMembro>> listar(@PageableDefault(size = 30, sort = {"nome"}) Pageable paginacao) {
        return ResponseEntity.ok(membroService.listagemMembro(paginacao));
    }

    /**
     * @Membros Deletar o membro especifico do id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        membroService.excluirMembro(id);
        return ResponseEntity.noContent().build();
    }
}
