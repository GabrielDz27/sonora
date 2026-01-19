import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Formulario } from '../../core/services/formulario';
import { CadastroService } from '../../core/services/cadastro';
import { UsuarioInterface } from '../../core/types/type';
import { FormBase } from "../../components/form-base/form-base";

@Component({
  selector: 'app-cadastro',
  imports: [FormBase],
  templateUrl: './cadastro.html',
  styleUrl: './cadastro.css',
})
export class Cadastro {
  constructor(
    private formularioService: Formulario,
    private cadastroService: CadastroService,
    private router: Router
  ) { }

  cadastrar() {
    const formCadastro = this.formularioService.getCadastro();

    if (formCadastro?.valid) {
      const novoCadastro = formCadastro.getRawValue() as UsuarioInterface;
      console.log(novoCadastro)
      this.cadastroService.cadastrar(novoCadastro).subscribe({
        next: (value) => {
          console.log('Cadastro realizado com sucesso', value);
          this.router.navigate(['/login']);
        },
        error: (err) => {
          console.log('Erro ao realizar cadastro', err)
        }
      });
    }
  }
}
