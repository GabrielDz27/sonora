import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { RegistroProducaoDto } from '../models/registro-producao.models';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegistroProducaoService {
  private apiEntityUrl = `${environment.apiUrl}my_domain/my_service/entities/registroProducao`;
  private apiActionUrl = `${environment.apiUrl}my_domain/my_service/actions/registroProducao`;

  constructor(
    private http: HttpClient
  ) {
  }

  listarTodos(): Observable<RegistroProducaoDto[]> {
    return this.http.get<{ contents: RegistroProducaoDto[] }>(this.apiEntityUrl).pipe(
      map(res => res.contents)
    );
  }
  
  buscarPorId(id: string): Observable<RegistroProducaoDto> {
    const params = new HttpParams().set('filter', `id eq '${id}'`);
    return this.http.get<{ contents: RegistroProducaoDto[] }>(this.apiEntityUrl, { params }).pipe(
      map(res => res.contents[0])
    );
  }

  buscarPorFiltro(campo: 'maquina_id' | 'funcionario_id', valor: string): Observable<RegistroProducaoDto[]> {
    const params = new HttpParams().set('filter', `${campo} eq '${valor}'`);
    return this.http.get<{ contents: RegistroProducaoDto[] }>(this.apiEntityUrl, { params }).pipe(
      map(res => res.contents)
    );
  }

  salvar(dados: Partial<RegistroProducaoDto>): Observable<RegistroProducaoDto> {
    if (dados.id) {
      return this.http.put<RegistroProducaoDto>(`${this.apiEntityUrl}/${dados.id}`, dados);
    }
    return this.http.post<RegistroProducaoDto>(this.apiEntityUrl, dados);
  }

  excluir(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiEntityUrl}/${id}`);
  }

  finalizar(id: string): Observable<void> {
    return this.http.post<void>(`${this.apiActionUrl}/finalizar`, { id });
  }
}
