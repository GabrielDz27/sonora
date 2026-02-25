import { Component, signal, inject, OnInit, computed } from '@angular/core';
import { PecaService } from '../../services/peca.service';
import { PecaDto } from '../../models/peca.models';
import { LucideAngularModule, DollarSign, Skull, Plus, Package, Timer, Edit3, Pencil, Trash2 } from 'lucide-angular/src/icons';
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

  readonly DollarSign = DollarSign;
  readonly Skull = Skull;
  readonly Plus = Plus;
  readonly Package = Package;
  readonly Timer = Timer;
  readonly Edit3 = Edit3;
  readonly Pencil = Pencil;
  readonly Trash2 = Trash2;

  lista = signal<PecaDto[]>([]);
  itemParaEdicao = signal<PecaDto | undefined>(undefined);
  modalAberto = signal(false);

  totalPecas = computed(() => this.lista().length);
  valorTotal = computed(() => this.lista().reduce((acc, p) => acc + (p.valor || 0), 0));
  pecasMortas = computed(() => this.lista().filter(p => p.status === 'MORTA').length);

  ngOnInit() { this.carregar(); }

  carregar() {
    this.service.listarTodos().subscribe(res => this.lista.set(res));
  }

  abrirNovo() {
    this.itemParaEdicao.set(undefined);
    this.modalAberto.set(true);
  }

  abrirEditar(item: PecaDto) {
    console.log('Editando peça:', item);
    this.itemParaEdicao.set(item);
    this.modalAberto.set(true);
  }

  salvar(dados: PecaDto) {
    console.log('Salvando peça:', dados);
    this.service.salvar(dados).subscribe(() => {
      this.carregar();
      this.modalAberto.set(false);
    });
  }

  excluirPeca(id: string, nome: string) {
    if (confirm(`DESEJA REMOVER A PEÇA: ${nome}? \nEsta ação não pode ser desfeita.`)) {
      this.service.excluir(id).subscribe({
        next: () => {
          
          this.carregar(); 
          console.log('Registo removido do sistema.');
        },
        error: (err) => {
          alert('Erro ao excluir: A peça pode estar vinculada a uma produção ativa.');
        }
      });
    }
  }
}
