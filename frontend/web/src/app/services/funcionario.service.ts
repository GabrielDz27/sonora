import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  constructor() { }

  listarTodos():any{ return []; }

  buscarPorId(id:string){}

  salvar(dados:any):any{}

  excluir(id:string){}
}
