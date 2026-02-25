import { Component, inject, output, Input } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { MaquinaDto, statusMaquina } from '../../models/maquina.models';
import { LucideAngularModule, Cpu, AlertCircle, Activity, ChevronDown, X, CheckCircle } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-formulario-maquina',
  standalone: true,
  imports: [ReactiveFormsModule, LucideAngularModule],
  templateUrl: './formulario-maquina.component.html'
})
export class FormularioMaquinaComponent {
  private fb = inject(FormBuilder);

  readonly Cpu = Cpu;
  readonly AlertCircle = AlertCircle;
  readonly Activity = Activity;
  readonly ChevronDown = ChevronDown;
  readonly X = X;
  readonly CheckCircle = CheckCircle;

  private _dadosIniciais?: MaquinaDto;
  @Input() set dadosIniciais(value: MaquinaDto | undefined) {
    this._dadosIniciais = value;
    if (value) {
      this.form.patchValue(value);
    } else {
      this.form.reset();
    }
  }
  salvar = output<MaquinaDto>();
  cancelar = output<void>();

  form = this.fb.group({
    id: [null as string | null],
    nome: ['', [Validators.required, Validators.minLength(3)]],
    status: ['ATIVO' as statusMaquina, Validators.required]
  });

  // Values are applied via the `dadosIniciais` input setter

  enviar() {
    if (this.form.valid) {
      this.salvar.emit(this.form.value as MaquinaDto);
    }
  }
}