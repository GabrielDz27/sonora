import { Component, input, output } from '@angular/core';
import { LucideAngularModule, Layers, X } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-modal',
  imports: [LucideAngularModule],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css'
})
export class ModalComponent {
  readonly Layers = Layers;
  readonly X = X;

  exibir = input<boolean>(false);
  titulo = input<string>('Cadastro');
  fechar = output<void>();
}
