import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RelatorioQuery, RelatorioResponse } from '../models/relatorio.models';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class RelatorioService {
  
  private URL = `${environment.apiUrl}my_domain/my_service/queries/relatorio`;

  constructor(private http: HttpClient) {}

  buscarRelatorio(filtros: RelatorioQuery): Observable<RelatorioResponse> {
    return this.http.post<RelatorioResponse>(this.URL, filtros);
  }
}