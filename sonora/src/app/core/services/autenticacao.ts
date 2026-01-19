import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { Usuario } from './usuario';

interface AuthResponse {
  'jwt-token': string;
}

@Injectable({
  providedIn: 'root',
})
export class Autenticacao {
  private apiUrl: string = "http://localhost:8081";

  constructor(
    private http: HttpClient,
    private userService: Usuario
  ) {}

  autenticar(login: any, senha: any): Observable<HttpResponse<AuthResponse>>  {
    return this.http.post<AuthResponse>(
      `${this.apiUrl}/auth/login`,
      { login, senha },
      { observe: 'response'}
    ).pipe(
      tap((response) => {
        const authToken = response.body? response.body['jwt-token'] : '';
        this.userService.salvarToken(authToken);
      })
    );
  }
}
