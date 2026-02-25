import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { map, Observable, switchMap, tap } from 'rxjs';
import { UsuarioService } from './usuario.service';
import { environment } from '../../../environments/environment.development';
import { FuncionarioDto, UsuarioVM } from '../../models/funcionario.models';
import { FuncionarioService } from '../funcionario.service';
import { Route } from 'lucide-angular';

interface LoginApiResponse {
  jsonToken: string;
  resetPasswordInfo: {
    expiredPassword: boolean;
    passwordExpiryAt: string;
  };
}

interface ParsedToken {
  access_token: string;
  refresh_token: string;
  token_type: string;
  expires_in: number;
  username: string;
  scope: string;
  version: number;
}

@Injectable({
  providedIn: 'root'
})
export class AutenticacaoService {
  private apiUrl = environment.apiUrl;

  private funcionarioService = inject(FuncionarioService);

  constructor(private http: HttpClient, private usuarioService: UsuarioService) { }
  login(username: string, password: string): Observable<UsuarioVM> {
    return this.http
      .post<LoginApiResponse>(`${this.apiUrl}platform/authentication/actions/login`, { username, password })
      .pipe(
        map(res => JSON.parse(res.jsonToken) as ParsedToken),
        tap(parsed => {
          localStorage.setItem('access_token', parsed.access_token);
          localStorage.setItem('refresh_token', parsed.refresh_token);
          localStorage.setItem('expires_in', String(parsed.expires_in));
          localStorage.setItem('username', parsed.username);
        }),
        switchMap(parsed => this.usuarioService.getIdFuncionario(parsed.username)),
        tap(u => {
          localStorage.setItem('id_usuario', u.id);
          localStorage.setItem('nome_usuario', u.nome);
        })
      );
  }

  logout() {
    localStorage.clear();
    
  }

  getAccessToken(): string | null {
    return localStorage.getItem('access_token');
  }

  isLoggedIn(): boolean {
    return !!this.getAccessToken();
  }

  usuarioLogado(): Observable<FuncionarioDto | null> {
    let nome = localStorage.getItem('username')?.toString();
    if ( nome) {
      return this.funcionarioService.getFuncionario(nome);
    }
    return null as any;
  }
}