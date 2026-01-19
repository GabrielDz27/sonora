import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Formulario } from '../../core/services/formulario';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatIcon } from "@angular/material/icon";
import { Container } from "../container/container";
import { FormValidations } from '../form-validations';

@Component({
  selector: 'app-form-base',
  imports: [ReactiveFormsModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatIcon, Container, MatDividerModule],
  templateUrl: './form-base.html',
  styleUrl: './form-base.css',
})
export class FormBase {
cadastroForm!: FormGroup;

  @Input() perfilComponent: boolean = false;
  @Input() titulo: string = 'Crie sua conta';
  @Input() textoBotao: string = 'CADASTRAR';
  @Output() acaoClique: EventEmitter<any> = new EventEmitter<any>()
  @Output() sair: EventEmitter<any> = new EventEmitter<any>()

  constructor(
    private formBuilder: FormBuilder,
    private formularioService: Formulario
  ) { }

  ngOnInit() {
    this.cadastroForm = this.formBuilder.group({
      login: [null, Validators.required],
      email: [null, [Validators.required, Validators.email]],
      senha: [null, [Validators.required, Validators.minLength(3)]],
      confirmarLogin: [null, [Validators.required, FormValidations.equalTo('login')]],
      confirmarSenha: [null, [Validators.required, Validators.minLength(3), FormValidations.equalTo('senha')]],
      aceitarTermos: [false, [Validators.requiredTrue]]
    });

    if(this.perfilComponent){
      this.cadastroForm.get('aceitarTermos')?.setValidators(null)
    } else {
      this.cadastroForm.get('aceitarTermos')?.setValidators([Validators.requiredTrue])
    }

    this.cadastroForm.get('aceitarTermos')?.updateValueAndValidity();

    this.formularioService.setCadastro(this.cadastroForm)
  }

  executarAcao() {
    this.acaoClique.emit();
  }

  deslogar() {
    this.sair.emit();
  }
}
