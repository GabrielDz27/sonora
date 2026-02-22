import { Component, signal } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario-peca',
  imports: [],
  templateUrl: './formulario-peca.component.html',
  styleUrl: './formulario-peca.component.css'
})
export class FormularioPecaComponent {
  modalAberto = signal(false);

  pecaForm = new FormGroup({
    id: new FormControl(null), // UUID
    nome: new FormControl('', Validators.required),
    codigoDesenho: new FormControl('', Validators.required),
    valor: new FormControl(0, Validators.required),
    tempoEstimadoMinutos: new FormControl(0, Validators.required),
    status: new FormControl('PENDENTE'),
    motivo_perda: new FormControl('')
  });

  fecharModal() {
    this.modalAberto.set(false);
    this.pecaForm.reset({ status: 'PENDENTE' });
  }
}
