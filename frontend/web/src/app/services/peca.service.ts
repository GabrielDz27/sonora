import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { FuncionarioDto } from '../models/funcionario.models';
import { map, Observable } from 'rxjs';
import { PecaDto } from '../models/peca.models';

@Injectable({
  providedIn: 'root',
})
export class PecaService {

  private apiEntityUrl = `${environment.apiUrl}my_domain/my_service/entities/peca`;

  constructor(
    private http: HttpClient
  ) {
  }

  getPecaByNome(nome: string): Observable<PecaDto[]> {
    return this.http.get<any>(this.apiEntityUrl + `?filter=containing(nome, '${nome}')`).pipe(map(res => res.contents as PecaDto[]));
  }

  listarTodos(): Observable<PecaDto[]> {
    return this.http.get<any>(this.apiEntityUrl).pipe(map(res => res.contents as PecaDto[]));
  }

  buscarPorId(id: string) {
    return this.http.get<any>(this.apiEntityUrl + `?filter=id eq ${id}`).pipe(map(res => res.contents[0] as PecaDto));
  }

  salvar(dados: any) {
    if (dados.id) {
      return this.http.put(this.apiEntityUrl + '/' + dados.id, dados);
    } else {
      return this.http.post(this.apiEntityUrl, dados);
    }
  }

  excluir(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiEntityUrl}/${id}`);
  }
}
