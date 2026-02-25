import { inject, Injectable } from '@angular/core';
import { MaquinaDto } from '../models/maquina.models';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MaquinaService {
  private http = inject(HttpClient);
  private API = `${environment.apiUrl}my_domain/my_service/entities/maquina`;

  constructor() { }
  listarTodos(): Observable<MaquinaDto[]> {
    return this.http.get<{ contents: MaquinaDto[] }>(this.API).pipe(
      map(res => res.contents)
    );
  }

  // Busca uma máquina específica pelo ID técnico
  buscarPorId(id: string): Observable<MaquinaDto> {
    const params = new HttpParams().set('filter', `id eq '${id}'`);
    return this.http.get<{ contents: MaquinaDto[] }>(this.API, { params }).pipe(
      map(res => res.contents[0])
    );
  }

  // Busca por nome ou tag (útil para filtros de busca rápida)
  buscarPorNome(nome: string): Observable<MaquinaDto[]> {
    const params = new HttpParams().set('filter', `containing(nome, '${nome}')`);
    return this.http.get<{ contents: MaquinaDto[] }>(this.API, { params }).pipe(
      map(res => res.contents)
    );
  }

  // Cria ou atualiza o cadastro da máquina
  salvar(dados: Partial<MaquinaDto>): Observable<MaquinaDto> {
    if (dados.id) {
      return this.http.put<MaquinaDto>(`${this.API}/${dados.id}`, dados);
    }
    return this.http.post<MaquinaDto>(this.API, dados);
  }

  // Exclui a máquina do sistema
  excluir(id: string): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`);
  }
}
