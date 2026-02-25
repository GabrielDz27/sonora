import { Component, inject, input, output, signal } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { PecaDto } from '../../models/peca.models';
import { FuncionarioDto } from '../../models/funcionario.models';
import { MaquinaDto } from '../../models/maquina.models';
import { RegistroProducaoDto } from '../../models/registro-producao.models';
import { LucideAngularModule, User, Cpu, Settings, Clock, PlayCircle } from 'lucide-angular/src/icons';
import { MaquinaService } from '../../services/maquina.service';
import { FuncionarioService } from '../../services/funcionario.service';
import { PecaService } from '../../services/peca.service';

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
  private maquinaService = inject(MaquinaService);
  private funcionarioService = inject(FuncionarioService);
  private pecaService = inject(PecaService);

  salvar = output<RegistroProducaoDto>();
  cancelar = output<void>();

  /** signals para armazenar dados */
  maquinas = signal<MaquinaDto[]>([]);
  funcionarios = signal<FuncionarioDto[]>([]);
  pecas = signal<PecaDto[]>([]);

  form = this.fb.group({
    funcionarioId: ['', Validators.required],
    maquinaId: ['', Validators.required],
    pecaId: ['', Validators.required]
  });

  dataAtual = new Date();

  ngOnInit() {
    this.carregarDados();
  }

  private carregarDados() {
    this.maquinaService.listarTodos()
      .subscribe(res => this.maquinas.set(res));

    this.funcionarioService.listarTodos()
      .subscribe(res => this.funcionarios.set(res));

    this.pecaService.listarTodos()
      .subscribe(res => this.pecas.set(res));
  }

  enviar() {
    if (this.form.valid) {
      const payload: RegistroProducaoDto = {
        funcionario: this.form.value.funcionarioId!,
        maquina: this.form.value.maquinaId!,
        peca: this.form.value.pecaId!,
        dataInicio: new Date().toISOString()
      };
      
      console.log('Emitting payload:', payload);
      this.salvar.emit(payload);
    }
  }
}