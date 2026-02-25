import { Component, inject, signal } from '@angular/core';
import { RelatorioQuery, RetornoRelatorio } from '../../models/relatorio.models';
import { RelatorioService } from '../../services/relatorio.service';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-relatorio',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './relatorio.component.html',
  styleUrl: './relatorio.component.css'
})
export class RelatorioComponent {
  private http = inject(HttpClient);
  
  // Signal para os dados (reatividade moderna)
  dados = signal<any[]>([]);

  // Objeto de filtros (o "in" do seu POST)
  filtros = {
    dataInicio: '',
    dataFinal: '',
    tipoRelatorio: 'ANALITICO',
    turno: '',
    funcionario: '',
    maquina: '',
    codigoDesenho: ''
  };

  gerarRelatorio() {
    const url = 'https://cloud-leaf.senior.com.br/t/senior.com.br/bridge/1.0/rest/my_domain/my_service/queries/relatorio';
    
    // Montando o "in" exatamente como o seu Record pede
    const body = {
      in: {
        dataInicio: this.filtros.dataInicio ? `${this.filtros.dataInicio}:00Z` : null,
        dataFinal: this.filtros.dataFinal ? `${this.filtros.dataFinal}:00Z` : null,
        tipoRelatorio: this.filtros.tipoRelatorio,
        turno: this.filtros.turno || null,
        // Transformando a string em List<> do Java (Array do TS)
        funcionario: this.converterParaLista(this.filtros.funcionario),
        maquina: this.converterParaLista(this.filtros.maquina),
        codigoDesenho: this.converterParaLista(this.filtros.codigoDesenho)
      }
    };

    this.http.post<any>(url, body).subscribe(res => {
      // O seu Record diz que o resultado vem dentro de "retorno"
      this.dados.set(res.retorno || []);
    });
  }

  private converterParaLista(val: string): string[] {
    return val ? val.split(',').map(v => v.trim()) : [];
  }
}
