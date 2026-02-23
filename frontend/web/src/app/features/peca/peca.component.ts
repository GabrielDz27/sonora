import { Component, signal, inject, OnInit, computed } from '@angular/core';
import { PecaService } from '../../services/peca.service';
import { PecaDto } from '../../models/peca.models';
import { LucideAngularModule } from 'lucide-angular/src/icons';
import { ModalComponent } from '../../shared/modal/modal.component';
import { FormularioPecaComponent } from '../../shared/formulario-peca/formulario-peca.component';
import { CurrencyPipe, CommonModule } from '@angular/common';
@Component({
  selector: 'app-peca',
  standalone: true,
  imports: [LucideAngularModule, CurrencyPipe, CommonModule, ModalComponent, FormularioPecaComponent],
  templateUrl: './peca.component.html',
  styleUrl: './peca.component.css'
})
export class PecaComponent {
  private service = inject(PecaService);

  lista = signal<PecaDto[]>([]);
  itemParaEdicao = signal<PecaDto | undefined>(undefined);
  modalAberto = signal(false);

  totalPecas = computed(() => this.lista().length);
  valorTotal = computed(() => this.lista().reduce((acc, p) => acc + (p.valor || 0), 0));
  pecasMortas = computed(() => this.lista().filter(p => p.status === 'MORTA').length);

  ngOnInit() { this.carregar(); }

  carregar() {
    // this.service.listarTodos().subscribe(res => this.lista.set(res));
  }

  abrirNovo() {
    this.itemParaEdicao.set(undefined);
    this.modalAberto.set(true);
  }

  abrirEditar(item: PecaDto) {
    this.itemParaEdicao.set(item);
    this.modalAberto.set(true);
  }

  salvar(dados: PecaDto) {
    // this.service.salvar(dados).subscribe(() => {
    //   this.carregar();
    //   this.modalAberto.set(false);
    // });
  }
}
