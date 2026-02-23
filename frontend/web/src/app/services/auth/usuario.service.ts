import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment.development';
import { UsuarioVM } from '../../models/funcionario.models';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiQueryUrl = `${environment.apiUrl}my_domain/my_service/queries`;

  constructor(
    private http: HttpClient
  ) {
  }

  getIdFuncionario(username: string): Observable<UsuarioVM> {
    return this.http.get<UsuarioVM>(this.apiQueryUrl + '/retornaIdFuncionario', {params: {username}});
  }
}
