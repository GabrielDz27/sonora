import { Component, inject, output, Input, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { FuncionarioDto, turno } from '../../models/funcionario.models';
import { LucideAngularModule } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-formulario-funcionario',
  standalone: true,
  imports: [ReactiveFormsModule, LucideAngularModule],
  templateUrl: './formulario-funcionario.component.html'
})
export class FormularioFuncionarioComponent implements OnInit {
  private fb = inject(FormBuilder);
  
  @Input() dadosIniciais?: FuncionarioDto;
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

  ngOnInit() {
    if (this.dadosIniciais) {
      this.form.patchValue(this.dadosIniciais);
    }

    if (!this.form.get('username')?.value) {
      const storedUsername = localStorage.getItem('username');
      if (storedUsername) {
        this.form.get('username')?.setValue(storedUsername);
      }
    }
  }

  enviar() {
    if (this.form.valid) {
      this.salvar.emit(this.form.value as FuncionarioDto);
    }
  }
}