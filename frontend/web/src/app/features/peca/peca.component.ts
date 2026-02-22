import { Component, signal } from '@angular/core';
import { Peca } from '../../models/models';

@Component({
  selector: 'app-peca',
  imports: [],
  templateUrl: './peca.component.html',
  styleUrl: './peca.component.css'
})
export class PecaComponent {
  pecas = signal<Peca[]>([]);
  
  // Signal para abrir/fechar o modal
  modalAberto = signal(false);

  getStatusColor(status: string): string {
    const cores = {
      'PENDENTE': 'bg-gray-100 text-gray-600',
      'PROCESSO': 'bg-blue-100 text-blue-600',
      'FINALIZADO': 'bg-green-100 text-green-600',
      'MORTA': 'bg-red-100 text-red-600'
    };
    return cores[status as keyof typeof cores] || cores.PENDENTE;
  }

  abrirModalNovo() {
    this.modalAberto.set(true);
  }
}
