import { Component, signal, computed, inject, AfterViewInit, ViewChild, ElementRef, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import Chart from 'chart.js/auto';

import { RelatorioService } from '../../services/relatorio.service';
import { FuncionarioService } from '../../services/funcionario.service';
import { MaquinaService } from '../../services/maquina.service';
import { PecaService } from '../../services/peca.service';

import { RelatorioView } from '../../models/relatorio-view.models';
import { forkJoin } from 'rxjs';
import { RelatorioQuery } from '../../models/relatorio.models';

@Component({
  selector: 'app-relatorio',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './relatorio.component.html',
  styleUrl: './relatorio.component.css'
})
export class RelatorioComponent implements OnInit, AfterViewInit {

  // services
  private relatorioService = inject(RelatorioService);
  private funcionarioService = inject(FuncionarioService);
  private maquinaService = inject(MaquinaService);
  private pecaService = inject(PecaService);

  // charts refs
  @ViewChild('graficoMaquinas') graficoMaquinasRef!: ElementRef;
  @ViewChild('graficoFuncionarios') graficoFuncionariosRef!: ElementRef;

  chartMaquinas!: Chart;
  chartFuncionarios!: Chart;

  // signals
  relatorio = signal<RelatorioView | null>(null);
  carregando = signal(false);

  funcionarios = signal<any[]>([]);
  maquinas = signal<any[]>([]);
  pecas = signal<any[]>([]);

  filtros = signal<RelatorioQuery>({
    dataInicio: new Date(new Date().setHours(0, 0, 0, 0)).toISOString(),
    dataFinal: new Date().toISOString(),
    tipoRelatorio: 'PERIODO',
    funcionario: [],
    maquina: [],
    codigoDesenho: []
  });

  // KPIs
  maquinaTop = computed(() => this.relatorio()?.rankingMaquinas[0]);
  funcionarioTop = computed(() => this.relatorio()?.producaoFuncionario[0]);

  // INIT
  ngOnInit() {
    this.carregarSelects();
  }

  ngAfterViewInit() { }

  // carregar selects
  carregarSelects() {
    forkJoin({
      func: this.funcionarioService.listarTodos(),
      maq: this.maquinaService.listarTodos(),
      pec: this.pecaService.listarTodos()
    }).subscribe(res => {
      this.funcionarios.set(res.func);
      this.maquinas.set(res.maq);
      this.pecas.set(res.pec);

      this.gerarRelatorio();
    });
  }

  // gerar relatório
  gerarRelatorio() {
    this.carregando.set(true);

    this.relatorioService.buscarRelatorioView(this.filtros())
      .subscribe({
        next: res => {
          this.relatorio.set(res);
          this.carregando.set(false);
          setTimeout(() => this.renderGraficos());
        },
        error: err => {
          console.error(err);
          this.carregando.set(false);
        }
      });
  }

  // charts
  renderGraficos() {
    const data = this.relatorio();
    if (!data) return;

    this.chartMaquinas?.destroy();
    this.chartFuncionarios?.destroy();

    this.chartMaquinas = new Chart(this.graficoMaquinasRef.nativeElement, {
      type: 'bar',
      data: {
        labels: data.rankingMaquinas.map(x => x.nome),
        datasets: [{ label: 'Horas', data: data.rankingMaquinas.map(x => x.horas) }]
      }
    });

    this.chartFuncionarios = new Chart(this.graficoFuncionariosRef.nativeElement, {
      type: 'bar',
      data: {
        labels: data.producaoFuncionario.map(x => x.nome),
        datasets: [{ label: 'Peças', data: data.producaoFuncionario.map(x => x.pecas) }]
      }
    });
  }

  // filtro change
  atualizarFiltro(campo: string, valor: any) {
    this.filtros.update(f => ({ ...f, [campo]: valor }));
  }

  // export futuro
  exportar() {
    console.log("Exportando PDF futuramente", this.relatorio());
  }
}