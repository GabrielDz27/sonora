import { Component, signal, inject, OnInit, computed } from '@angular/core';
import { MaquinaService } from '../../services/maquina.service';
import { MaquinaDto } from '../../models/maquina.models';
import { LucideAngularModule, CheckCircle, Wrench, Plus, AlertTriangle, Cpu, Edit3, Trash2, Barcode } from 'lucide-angular/src/icons';
import { ModalComponent } from '../../shared/modal/modal.component';
import { FormularioMaquinaComponent } from '../../shared/formulario-maquina/formulario-maquina.component';

@Component({
  selector: 'app-maquina',
  standalone: true,
  imports: [LucideAngularModule, ModalComponent, FormularioMaquinaComponent],
  templateUrl: './maquina.component.html',
  styleUrl: './maquina.component.css'
})
export class MaquinaComponent {
  private service = inject(MaquinaService);

  readonly CheckCircle = CheckCircle;
  readonly Wrench = Wrench;
  readonly Plus = Plus;
  readonly AlertTriangle = AlertTriangle;
  readonly Cpu = Cpu;
  readonly Edit3 = Edit3;
  readonly Trash2 = Trash2;
  readonly Barcode = Barcode;

  lista = signal<MaquinaDto[]>([]);
  itemParaEdicao = signal<MaquinaDto | undefined>(undefined);
  modalAberto = signal(false);

  // Estatísticas calculadas automaticamente
  totalAtivas = computed(() => this.lista().filter(m => m.status === 'ATIVO').length);
  totalManutencao = computed(() => this.lista().filter(m => m.status === 'MANUTENCAO').length);

  ngOnInit() { this.carregar(); }

  carregar() {
    // this.service.listarTodos().subscribe(res => this.lista.set(res));
  }

  abrirNovo() {
    this.itemParaEdicao.set(undefined);
    this.modalAberto.set(true);
  }

  abrirEditar(item: MaquinaDto) {
    this.itemParaEdicao.set(item);
    this.modalAberto.set(true);
  }

  salvar(dados: MaquinaDto) {
    this.service.salvar(dados).subscribe(() => {
      this.carregar();
      this.modalAberto.set(false);
    });
  }

  excluir(id: string) {
    if (confirm('Deseja realmente remover este ativo do inventário?')) {
      // this.service.excluir(id).subscribe(() => this.carregar());
    }
  }
}
