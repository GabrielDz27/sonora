import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SalaInterface } from '../types/type';
import { environment } from '/Users/gabriel.ferreira/cursoAngular/sonora/src/environments/environment';


@Injectable({
  providedIn: 'root',
})
export class SalaService {
  
  private apiUrl: string = environment.apiUrl;
  
  constructor(
    private httpClient: HttpClient
  ) {}

  listar () : Observable<SalaInterface[]> {
    return this.httpClient.get<SalaInterface[]>(`${this.apiUrl}/promocoes`)
  }
  
  salvar(sala: Partial<SalaInterface>) {
    if (sala.id) return this.httpClient.put<SalaInterface>(`${this.apiUrl}/${sala.id}`, sala);
    return this.httpClient.post<SalaInterface>(this.apiUrl, sala);
  }

  excluir(id: number) { return this.httpClient.delete(`${this.apiUrl}/${id}`); }
}
