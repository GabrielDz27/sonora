import { Component, input, output } from '@angular/core';
import { LucideAngularModule } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-modal',
  imports: [LucideAngularModule],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css'
})
export class ModalComponent {
  exibir = input<boolean>(false);
  titulo = input<string>('Cadastro');
  fechar = output<void>();
}
