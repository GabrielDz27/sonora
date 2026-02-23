import { Component, inject, output, Input, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { MaquinaDto, statusMaquina } from '../../models/maquina.models';
import { LucideAngularModule } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-formulario-maquina',
  standalone: true,
  imports: [ReactiveFormsModule, LucideAngularModule],
  templateUrl: './formulario-maquina.component.html'
})
export class FormularioMaquinaComponent implements OnInit {
  private fb = inject(FormBuilder);

  @Input() dadosIniciais?: MaquinaDto;
  salvar = output<MaquinaDto>();
  cancelar = output<void>();

  form = this.fb.group({
    id: [null as string | null],
    nome: ['', [Validators.required, Validators.minLength(3)]],
    status: ['ATIVO' as statusMaquina, Validators.required]
  });

  ngOnInit() {
    if (this.dadosIniciais) {
      this.form.patchValue(this.dadosIniciais);
    }
  }

  enviar() {
    if (this.form.valid) {
      this.salvar.emit(this.form.value as MaquinaDto);
    }
  }
}