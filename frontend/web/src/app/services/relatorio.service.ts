import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { RelatorioQuery, RelatorioResponse } from '../models/relatorio.models';
import { environment } from '../../environments/environment';
import { mapRelatorio } from './adapters/relatorio.adapter';
import { RelatorioView } from '../models/relatorio-view.models';

@Injectable({ providedIn: 'root' })
export class RelatorioService {

  private URL = `${environment.apiUrl}my_domain/my_service/queries/relatorio`;

  constructor(private http: HttpClient) { }

  buscarRelatorioView(filtros: RelatorioQuery): Observable<RelatorioView> {
    return this.http.post<RelatorioResponse>(this.URL, filtros)
      .pipe(map(mapRelatorio));
  }
}