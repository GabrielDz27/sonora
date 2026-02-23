import { Component, signal, inject, OnInit } from '@angular/core';
import { FuncionarioService } from '../../services/funcionario.service';
import { FuncionarioDto } from '../../models/funcionario.models';
import { LucideAngularModule } from 'lucide-angular/src/icons';
import { ModalComponent } from '../../shared/modal/modal.component';
import { FormularioFuncionarioComponent } from '../../shared/formulario-funcionario/formulario-funcionario.component';

@Component({
  selector: 'app-pagina-funcionarios',
  standalone: true,
  imports: [LucideAngularModule, ModalComponent, FormularioFuncionarioComponent],
  templateUrl: './funcionario.component.html'
})
export class FuncionarioComponent implements OnInit {
  private service = inject(FuncionarioService);

  lista = signal<FuncionarioDto[]>([]);
  itemParaEdicao = signal<FuncionarioDto | undefined>(undefined);
  modalAberto = signal(false);

  ngOnInit() { this.carregar(); }

  carregar() {
    // this.service.listarTodos().subscribe(res => this.lista.set(res));
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
    this.service.salvar(dados).subscribe(() => {
      this.carregar();
      this.modalAberto.set(false);
    });
  }
}