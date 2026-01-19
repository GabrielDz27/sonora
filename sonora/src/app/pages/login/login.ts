import { Component, inject, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Autenticacao } from '../../core/services/autenticacao';
import { Router } from '@angular/router';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatCardModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    RouterLink
  ],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login implements OnInit {
  constructor(router: Router) {}

  private fb = inject(FormBuilder);
  private authService = inject(Autenticacao);
  private router = inject(Router);

  loginForm!: FormGroup;

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      login: [null, [Validators.required]],
      senha: [null, Validators.required]
    })
  }

  logar() {
    if (this.loginForm.valid) {
      const login = this.loginForm.value.login;
      const senha = this.loginForm.value.senha;

      this.authService.autenticar(login, senha).subscribe({
        next: (value) => {
          console.log('Autenticado com sucesso', value)
          this.router.navigate(['/']);
          this.loginForm.reset();
        },
        error: (err) => {
          console.log('Problema na autenticação', err)
        },
      })
      
      console.log('Dados de login:', this.loginForm.value);
    }
  }
}
