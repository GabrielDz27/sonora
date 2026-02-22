import { Component, inject, input, output } from '@angular/core';
import { Peca } from '../../services/peca';
import { Funcionario, Maquina } from '../../models/models';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario-registro-producao',
  imports: [],
  templateUrl: './formulario-registro-producao.component.html',
  styleUrl: './formulario-registro-producao.component.css'
})
export class FormularioRegistroProducaoComponent {
  pecas = input<Peca[]>([]);
  funcionarios = input<Funcionario[]>([]);
  maquinas = input<Maquina[]>([]);

  form = inject(FormBuilder).group({
    funcionario: [null, Validators.required],
    maquina: [null, Validators.required],
    peca: [null, Validators.required]
  });

  salvar = output<any>();
  cancelar = output <void>();

  enviar() {
    if (this.form.valid) {
      this.salvar.emit({
        ...this.form.value,
        dataInicio: new Date() // Gerado no momento do clique
      });
    }
  }
}
