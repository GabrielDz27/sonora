import { Component, inject, output, Input } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { FuncionarioDto, turno } from '../../models/funcionario.models';
import { LucideAngularModule, User, IdCard, Briefcase, Clock, ChevronDown, Database, X, CheckCircle } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-formulario-funcionario',
  standalone: true,
  imports: [ReactiveFormsModule, LucideAngularModule],
  templateUrl: './formulario-funcionario.component.html'
})
export class FormularioFuncionarioComponent {
  private fb = inject(FormBuilder);
  
  readonly User = User;
  readonly IdCard = IdCard;
  readonly Briefcase = Briefcase;
  readonly Clock = Clock;
  readonly ChevronDown = ChevronDown;
  readonly Database = Database;
  readonly X = X;
  readonly CheckCircle = CheckCircle;

  private _dadosIniciais?: FuncionarioDto;
  @Input() set dadosIniciais(value: FuncionarioDto | undefined) {
    this._dadosIniciais = value;
    if (value) {
      const patched = { ...value } as any;
      if (patched.ativo === undefined || patched.ativo === null) patched.ativo = true;
      if (!patched.username) patched.username = localStorage.getItem('username') ?? '';
      this.form.patchValue(patched);
    } else {
      const storedUsername = localStorage.getItem('username') ?? '';
      this.form.reset({ ativo: true, turno: 'PRIMEIRO', username: storedUsername });
    }
  }
  salvar = output<FuncionarioDto>();
  cancelar = output<void>();

  form = this.fb.group({
    id: [null as string | null],
    nome: ['', [Validators.required]],
    matricula: ['', [Validators.required]],
    cargo: ['', [Validators.required]],
    turno: ['PRIMEIRO' as turno, Validators.required],
    ativo: [true],
    username: [''] 
  });

  // Apply stored username on component creation
  private _initUsername() {
    if (!this.form.get('username')?.value) {
      const storedUsername = localStorage.getItem('username');
      if (storedUsername) {
        this.form.get('username')?.setValue(storedUsername);
      }
    }
  }

  constructor() {
    this._initUsername();
  }

  enviar() {
    if (this.form.valid) {
      this.salvar.emit(this.form.value as FuncionarioDto);
    }
  }
}