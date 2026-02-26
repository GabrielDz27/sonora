import { Component, signal, inject, OnInit, computed } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { LucideAngularModule, Activity, PlayCircle, Cpu, Settings, ArrowRight, Square } from 'lucide-angular/src/icons';
import { RegistroProducaoService } from '../../services/registro-producao.service';
import { RegistroProducaoDto, RegistroProducaoPaginaDto } from '../../models/registro-producao.models';
import { FuncionarioService } from '../../services/funcionario.service';
import { MaquinaService } from '../../services/maquina.service';
import { PecaService } from '../../services/peca.service';
import { forkJoin, map, switchMap, of } from 'rxjs';
import { ModalComponent } from '../../shared/modal/modal.component';
import { FormularioRegistroProducaoComponent } from '../../shared/formulario-registro-producao/formulario-registro-producao.component';
import { AlertService } from '../../shared/ui/alert/alert.service';


@Component({
  selector: 'app-pagina-registro-producao',
  standalone: true,
  imports: [CommonModule, LucideAngularModule, ModalComponent, FormularioRegistroProducaoComponent, DatePipe],
  templateUrl: './registro-producao.component.html'
})
export class RegistroProducaoComponent implements OnInit {
  private service = inject(RegistroProducaoService);
  private funcionarioService = inject(FuncionarioService);
  private maquinaService = inject(MaquinaService);
  private pecaService = inject(PecaService);
  private alertService = inject(AlertService);

  readonly Activity = Activity;
  readonly PlayCircle = PlayCircle;
  readonly Cpu = Cpu;
  readonly Settings = Settings;
  readonly ArrowRight = ArrowRight;
  readonly Square = Square;

  registros = signal<RegistroProducaoPaginaDto[]>([]);
  modalAberto = signal(false);
  
  producoesAtivas = computed(() => this.registros().filter(r => !r.dataFinal).length);

  ngOnInit() { this.carregar(); }

  carregar() {
  this.service.listarTodosCompleta()
    .pipe(
      map(items =>
        items.map(item => ({
          id: item.id,
          funcionario: item.funcionario?.nome ?? '---',
          maquina: item.maquina?.nome ?? '---',
          peca: item.peca?.nome ?? '---',
          dataInicio: item.dataInicio,
          dataFinal: item.dataFinal
        }))
      )
    )
    .subscribe(res => this.registros.set(res));
}

  iniciarNovoRegistro() {
    this.modalAberto.set(true);
  }

  salvarNovo(dados: RegistroProducaoDto) {
    this.service.salvar(dados).subscribe({
      next: () => {
        this.alertService.toast('success', 'Registro de produção iniciado!');
        this.service.mudarStatusPeca(dados.peca.id!, 'PROCESSO');
        this.carregar();
        this.modalAberto.set(false);
      },
      error: (err) => {
        this.alertService.toast('error', 'Erro ao salvar', err.error?.message || 'Verifique os dados e tente novamente');
        console.error('Erro ao salvar registro:', err);
      }
    });
  }

  finalizarRegistro(id: string) {
    this.service.finalizar(id).subscribe({
      next: () => {
        this.alertService.toast('success', 'Registro finalizado!');
        this.carregar();
      },
      error: (err) => {
        this.alertService.toast('error', 'Erro ao finalizar', err.error?.message || 'Tente novamente mais tarde');
        console.error('Erro ao finalizar registro:', err);
      }
    });
  }
}