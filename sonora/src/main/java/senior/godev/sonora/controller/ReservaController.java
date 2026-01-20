package senior.godev.sonora.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import senior.godev.sonora.models.reserva.dto.DadosCadastroReserva;
import senior.godev.sonora.models.reserva.dto.DadosCancelamentoReserva;
import senior.godev.sonora.models.reserva.dto.DadosConfirmacaoReserva;
import senior.godev.sonora.models.reserva.dto.DadosListagemReserva;
import senior.godev.sonora.service.ReservaService;

/**
 * @reserva
 * @Endpoints Maioria das coisas vão ser feita no service por questão de regar de negocio
 */
@RestController
@RequestMapping("/reserva")
class ReservaController {

  @Autowired
  private ReservaService reservaService;

  /**
   * @reserva Vai criar uma reserva
   */
  @PostMapping
  @Transactional
  public ResponseEntity reserva(@RequestBody @Valid DadosCadastroReserva dadosCadastroReserva) {
    return ResponseEntity.ok(reservaService.reservar(dadosCadastroReserva));
  }

  /**
   * @reserva Vai cancelar uma reserva,
   */
  @DeleteMapping
  @Transactional
  public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoReserva dados) {
    reservaService.cancelar(dados);
    return ResponseEntity.noContent().build();
  }

  /**
   * @reserva Vai confirmar uma reserva,
   */
  @PostMapping("/confirmar")
  @Transactional
  public ResponseEntity confirmar(@RequestBody @Valid DadosConfirmacaoReserva dadosConfirmacaoReserva) {
    reservaService.confirmar(dadosConfirmacaoReserva);
    return ResponseEntity.noContent().build();
  }

  /**
   * @reserva Vai informar as reservas conforme o em aplitude maior para admistrador
   */
  @GetMapping("/geral")
  @PreAuthorize("hasRole('ADMINISTRADOR')")
  public ResponseEntity<Page<DadosListagemReserva>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
    return ResponseEntity.ok(reservaService.listagem(paginacao));
  }

  @GetMapping
  public ResponseEntity<Page<DadosListagemReserva>> listarMembro(Long idMembro, @PageableDefault(size = 100, sort = {"id"}) Pageable paginacao) {
    return ResponseEntity.ok(reservaService.listagemMembro(idMembro, paginacao));
  }
}
