import { inject, Injectable } from '@angular/core';
import { MaquinaDto } from '../models/maquina.models';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MaquinaService {
  private http = inject(HttpClient);
  private API = `${environment.apiUrl}my_domain/my_service/entities/maquina`;

  constructor() { }
  listarTodos(){}

  buscarPorId(id:string){}

  salvar(dados:any){
    if (dados.id) {
      return this.http.put<MaquinaDto>(this.API, dados);
    }
    return this.http.post<MaquinaDto>(this.API, dados);
  }

  excluir(id:string){}
}
