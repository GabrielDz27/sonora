import { Injectable } from '@angular/core';
import { Token } from './token';
import { jwtDecode } from 'jwt-decode';
import { BehaviorSubject } from 'rxjs';
import { UsuarioInterface } from '../types/type';


@Injectable({
  providedIn: 'root',
})
export class Usuario {
  
  private userSubject = new BehaviorSubject<UsuarioInterface | null>(null);

  constructor(private tokenService: Token) {
    if(this.tokenService.possuiToken()) {
      this.decodificarJWT();
    }
  }

  private decodificarJWT() {
    const token = this.tokenService.retornarToken();
    const user = jwtDecode(token) as UsuarioInterface;
    this.userSubject.next(user);
  }

  retornarUser() {
    return this.userSubject.asObservable();
  }

  salvarToken(token: string) {
    this.tokenService.salvarToken(token);
    this.decodificarJWT();
  }

  logout() {
    this.tokenService.excluirToken();
    this.userSubject.next(null);
  }

  estaLogado() {
    return this.tokenService.possuiToken();
  }
}
