import { Component, inject, output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario-funcionario',
  imports: [],
  templateUrl: './formulario-funcionario.component.html',
  styleUrl: './formulario-funcionario.component.css'
})
export class FormularioFuncionarioComponent {
  private fb = inject(FormBuilder);
  
  form = this.fb.group({
    id: [null],
    nome: ['', Validators.required],
    matricula: ['', Validators.required],
    cargo: ['', Validators.required],
    turno: ['MANHA', Validators.required],
    ativo: [true]
  });

  salvar = output<any>();
  cancelar = output<void>();

  enviar() {
    if (this.form.valid) this.salvar.emit(this.form.value);
  }
}
