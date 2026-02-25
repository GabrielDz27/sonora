import { Component, signal, inject, OnInit, computed } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { LucideAngularModule, Activity, PlayCircle, Cpu, Settings, ArrowRight, Square } from 'lucide-angular/src/icons';
import { RegistroProducaoService } from '../../services/registro-producao.service';
import { RegistroProducaoDto } from '../../models/registro-producao.models';
import { ModalComponent } from '../../shared/modal/modal.component';
import { FormularioRegistroProducaoComponent } from '../../shared/formulario-registro-producao/formulario-registro-producao.component';


@Component({
  selector: 'app-pagina-registro-producao',
  standalone: true,
  imports: [CommonModule, LucideAngularModule, ModalComponent, FormularioRegistroProducaoComponent, DatePipe],
  templateUrl: './registro-producao.component.html'
})
export class RegistroProducaoComponent implements OnInit {
  private service = inject(RegistroProducaoService);

  readonly Activity = Activity;
  readonly PlayCircle = PlayCircle;
  readonly Cpu = Cpu;
  readonly Settings = Settings;
  readonly ArrowRight = ArrowRight;
  readonly Square = Square;

  registros = signal<RegistroProducaoDto[]>([]);
  modalAberto = signal(false);
  
  producoesAtivas = computed(() => this.registros().filter(r => !r.dataFinal).length);

  ngOnInit() { this.carregar(); }

  carregar() {
    this.service.listarTodos().subscribe(res => this.registros.set(res));
  }

  iniciarNovoRegistro() {
    this.modalAberto.set(true);
  }

  salvarNovo(dados: RegistroProducaoDto) {
    this.service.salvar(dados).subscribe(() => {
      this.carregar();
      this.modalAberto.set(false);
    });
  }

  finalizarRegistro(id: string) {
    // Lógica para enviar a dataFim para o backend
    // this.service.finalizar(id).subscribe(() => this.carregar());
  }
}