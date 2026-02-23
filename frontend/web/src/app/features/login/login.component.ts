import { Component, inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AutenticacaoService } from '../../services/auth/autenticacao.service';
import { ButtonComponent } from '../../shared/ui/button/button.component';
import { LucideAngularModule } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ButtonComponent, LucideAngularModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
   private fb = inject(FormBuilder);
  private auth = inject(AutenticacaoService);
  private router = inject(Router);

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
        this.router.navigateByUrl('/dashboard');
      },
      error: () => {
        this.loading = false;
        this.errorMsg = 'Não foi possível entrar. Verifique suas credenciais.';
      },
    });
  }

}
