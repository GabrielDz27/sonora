import { Component, signal, inject, OnInit } from '@angular/core';
import { FuncionarioService } from '../../services/funcionario.service';
import { FuncionarioDto } from '../../models/funcionario.models';
import { LucideAngularModule, Plus, User, Edit3 } from 'lucide-angular/src/icons';
import { ModalComponent } from '../../shared/modal/modal.component';
import { FormularioFuncionarioComponent } from '../../shared/formulario-funcionario/formulario-funcionario.component';
import { AlertService } from '../../shared/ui/alert/alert.service';

@Component({
  selector: 'app-pagina-funcionarios',
  standalone: true,
  imports: [LucideAngularModule, ModalComponent, FormularioFuncionarioComponent],
  templateUrl: './funcionario.component.html'
})
export class FuncionarioComponent implements OnInit {
  private service = inject(FuncionarioService);
  private alertService = inject(AlertService);

  readonly Plus = Plus;
  readonly User = User;
  readonly Edit3 = Edit3;

  lista = signal<FuncionarioDto[]>([]);
  itemParaEdicao = signal<FuncionarioDto | undefined>(undefined);
  modalAberto = signal(false);

  ngOnInit() { this.carregar(); 
  }

  carregar() {
    this.service.listarTodos().subscribe(res => this.lista.set(res));
  }

  abrirNovo() {
    this.itemParaEdicao.set(undefined);
    this.modalAberto.set(true);
  }

  abrirEditar(item: FuncionarioDto) {
    this.itemParaEdicao.set(item);
    this.modalAberto.set(true);
  }

  salvar(dados: FuncionarioDto) {
    this.service.salvar(dados).subscribe({
      next: () => {
        const titulo = dados.id ? 'Colaborador atualizado!' : 'Colaborador cadastrado!';
        this.alertService.toast('success', titulo);
        this.carregar();
        this.modalAberto.set(false);
      },
      error: (err) => {
        this.alertService.toast('error', 'Erro ao salvar', err.error?.message || 'Verifique os dados e tente novamente');
        console.error('Erro ao salvar funcionário:', err);
      }
    });
  }
}