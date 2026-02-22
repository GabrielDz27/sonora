import { Component, inject, output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario-maquina',
  imports: [],
  templateUrl: './formulario-maquina.component.html',
  styleUrl: './formulario-maquina.component.css'
})
export class FormularioMaquinaComponent {
  form = inject(FormBuilder).group({
    id: [null],
    nome: ['', Validators.required],
    status: ['ATIVO', Validators.required]
  });

  salvar = output<any>();
  cancelar = output<void>();

  enviar() {
    if (this.form.valid) this.salvar.emit(this.form.value);
  }
}
