package senior.godev.sonora.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import senior.godev.sonora.models.reserva.dto.DadosCadastroReserva;
import senior.godev.sonora.models.reserva.dto.DadosCancelamentoReserva;
import senior.godev.sonora.models.reserva.dto.DadosConfirmacaoReserva;
import senior.godev.sonora.service.ReservaService;

@RestController
@RequestMapping("/reserva")
class ReservaController {

    @Autowired
    private ReservaService reservaService;

    /**
     * @reserva Vai criar uma reserva, ai utiliza o
     */
    @PostMapping
    @Transactional
    public ResponseEntity reserva(@RequestBody @Valid DadosCadastroReserva dadosCadastroReserva) {
        return ResponseEntity.ok(reservaService.reservar(dadosCadastroReserva));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoReserva dados) {
        reservaService.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/confirmar")
    @Transactional
    public ResponseEntity confirmar(@RequestBody DadosConfirmacaoReserva dadosConfirmacaoReserva) {
        reservaService.confirmar(dadosConfirmacaoReserva);
        return ResponseEntity.noContent().build();
    }
}
