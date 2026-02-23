import { Component, signal } from '@angular/core';
import { Maquina } from '../../models/geral.models';

@Component({
  selector: 'app-maquina',
  imports: [],
  templateUrl: './maquina.component.html',
  styleUrl: './maquina.component.css'
})
export class MaquinaComponent {
  maquinas = signal<Maquina[]>([]); // Vinculado à sua Interface
  modalAberto = signal(false);

  getStatusClass(status: string) {
    switch (status) {
      case 'ATIVO': return 'bg-green-100 text-green-700';
      case 'MANUTENCAO': return 'bg-yellow-100 text-yellow-700';
      case 'INATIVO': return 'bg-red-100 text-red-700';
      default: return 'bg-gray-100 text-gray-700';
    }
  }

  onSalvar(dados: any) {
    console.log('Enviando para o backend:', dados);
    // Aqui você chamará o MaquinaService
    this.modalAberto.set(false);
  }
}
