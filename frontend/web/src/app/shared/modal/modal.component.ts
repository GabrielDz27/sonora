import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-modal',
  imports: [],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css'
})
export class ModalComponent {
  exibir = input<boolean>(false);
  titulo = input<string>('Cadastro');
  fechar = output<void>();
}
