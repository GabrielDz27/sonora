import { Component, inject, input, output } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { PecaDto } from '../../models/peca.models';
import { FuncionarioDto } from '../../models/funcionario.models';
import { MaquinaDto } from '../../models/maquina.models';
import { RegistroProducaoDto } from '../../models/registro-producao.models';
import { LucideAngularModule, User, Cpu, Settings, Clock, PlayCircle } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-formulario-registro-producao',
  standalone: true,
  imports: [ReactiveFormsModule, DatePipe, LucideAngularModule], 
  templateUrl: './formulario-registro-producao.component.html'
})
export class FormularioRegistroProducaoComponent {
  readonly iconUser = User;
  readonly iconMachine = Cpu;
  readonly iconPart = Settings;
  readonly Clock = Clock;
  readonly PlayCircle = PlayCircle;

  private fb = inject(FormBuilder);

  pecas = input<PecaDto[]>([]);
  funcionarios = input<FuncionarioDto[]>([]);
  maquinas = input<MaquinaDto[]>([]);

  salvar = output<RegistroProducaoDto>();
  cancelar = output<void>();

  form = this.fb.group({
    funcionarioId: ['', Validators.required],
    maquinaId: ['', Validators.required],
    pecaId: ['', Validators.required]
  });

  dataAtual = new Date();

  enviar() {
    if (this.form.valid) {
      const payload: RegistroProducaoDto = {
        funcionario: this.form.value.funcionarioId!,
        maquina: this.form.value.maquinaId!,
        peca: this.form.value.pecaId!,
        dataInicio: new Date().toISOString()
      };
      this.salvar.emit(payload);
    }
  }
}