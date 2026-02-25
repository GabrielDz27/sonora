import { Injectable } from '@angular/core';
import { FuncionarioDto, UsuarioVM } from '../models/funcionario.models';
import { map, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {
  private apiQueryUrl = `${environment.apiUrl}my_domain/my_service/queries`;
  private apiEntityUrl = `${environment.apiUrl}my_domain/my_service/entities/funcionario`;

  constructor(
    private http: HttpClient
  ) {
  }

  getFuncionario(username: string): Observable<FuncionarioDto> {
    return this.http.get<any>(this.apiEntityUrl, { params: { username } }).pipe(map(res => res.contents[0] as FuncionarioDto));
  }

  getFuncionarioByNome(nome: string): Observable<FuncionarioDto[]> {
    return this.http.get<any>(this.apiEntityUrl + `?filter=containing(nome, '${nome}')`).pipe(map(res => res.contents as FuncionarioDto[]));
  }

  listarTodos(): Observable<FuncionarioDto[]> {
    return this.http.get<any>(this.apiEntityUrl).pipe(map(res => res.contents as FuncionarioDto[]));
  }

  buscarPorId(id: string) {
    return this.http.get<any>(this.apiEntityUrl + `?filter=id eq ${id}`).pipe(map(res => res.contents[0] as FuncionarioDto));
  }

  salvar(dados: any) {
    if (dados.id) {
      return this.http.put(this.apiEntityUrl, dados);
    } else {
      return this.http.post(this.apiEntityUrl, dados);
    }
  }

  excluir(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiEntityUrl}/${id}`);
  }
}
