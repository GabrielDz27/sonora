import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { UsuarioInterface } from '../types/type';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CadastroService {
  private apiUrl: string = environment.apiUrl;
  constructor(private http: HttpClient) { }

  cadastrar(pessoaUsuaria: UsuarioInterface): Observable<UsuarioInterface> {
    return this.http.post<UsuarioInterface>(`${this.apiUrl}/auth/cadastro`, pessoaUsuaria);
  }

  buscarCadastro(): Observable<UsuarioInterface> {
    return this.http.get<UsuarioInterface>(`${this.apiUrl}/auth/perfil`);
  }

  editarCadastro(pessoaUsuaria: UsuarioInterface): Observable<UsuarioInterface> {
    return this.http.patch<UsuarioInterface>(`${this.apiUrl}/auth/perfil`, pessoaUsuaria);
  }
}
