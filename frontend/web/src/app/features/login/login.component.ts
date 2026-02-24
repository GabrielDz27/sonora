import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators,FormGroup, FormsModule, } from '@angular/forms';
import { Router } from '@angular/router';
import { AutenticacaoService } from '../../services/auth/autenticacao.service';
import { ButtonComponent } from '../../shared/ui/button/button.component';
import { LucideAngularModule, ShieldCheck, User, Key, ArrowRight, Loader2, AlertCircle } from 'lucide-angular/src/icons';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ButtonComponent, LucideAngularModule, ReactiveFormsModule, FormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  private fb = inject(FormBuilder);
  private auth = inject(AutenticacaoService);
  private router = inject(Router);

  readonly ShieldCheck = ShieldCheck;
  readonly User = User;
  readonly Key = Key;
  readonly ArrowRight = ArrowRight;
  readonly Loader2 = Loader2;
  readonly AlertCircle = AlertCircle;

  loading = false;  
  errorMsg = '';

  form = this.fb.group({
    username: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(3)]],
  });

  ngOnInit() {
    this.auth.logout();
  }

  submit() {
    this.errorMsg = '';

    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const { username, password } = this.form.getRawValue() as any;

    this.loading = true;
    this.auth.login(username, password).subscribe({
      next: () => {
        this.loading = false;
        this.router.navigateByUrl('/inicio');
      },
      error: () => {
        this.loading = false;
        this.errorMsg = 'Não foi possível entrar. Verifique suas credenciais.';
      },
    });
  }

}
