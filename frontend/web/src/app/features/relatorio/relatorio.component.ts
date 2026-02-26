import { Component, signal, computed, inject, AfterViewInit, ViewChild, ElementRef, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import Chart from 'chart.js/auto';

import { RelatorioService } from '../../services/relatorio.service';
import { FuncionarioService } from '../../services/funcionario.service';
import { MaquinaService } from '../../services/maquina.service';
import { PecaService } from '../../services/peca.service';
import { RegistroProducaoService } from '../../services/registro-producao.service';

import { RelatorioView } from '../../models/relatorio-view.models';
import { forkJoin } from 'rxjs';
import { RelatorioQuery } from '../../models/relatorio.models';
import { RegistroProducaoDetalhadoDto } from '../../models/registro-producao.models';

@Component({
  selector: 'app-relatorio',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './relatorio.component.html',
  styleUrl: './relatorio.component.css'
})
export class RelatorioComponent implements OnInit, AfterViewInit {

  private relatorioService = inject(RelatorioService);
  private funcionarioService = inject(FuncionarioService);
  private maquinaService = inject(MaquinaService);
  private pecaService = inject(PecaService);
  private registroProducaoService = inject(RegistroProducaoService);

  @ViewChild('graficoMaquinas') graficoMaquinasRef!: ElementRef;
  @ViewChild('graficoFuncionarios') graficoFuncionariosRef!: ElementRef;

  chartMaquinas!: Chart;
  chartFuncionarios!: Chart;

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

  maquinaTop = computed(() => this.relatorio()?.rankingMaquinas[0]);
  funcionarioTop = computed(() => this.relatorio()?.producaoFuncionario[0]);
  operadorDestaque = computed(() => this.relatorio()?.producaoFuncionario[0]);

  ngOnInit() {
    this.carregarSelects();
  }

  ngAfterViewInit() { }

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

  gerarRelatorio() {
    this.carregando.set(true);
    const filtrosAtuais = this.filtros();

    forkJoin({
      relatorio: this.relatorioService.buscarRelatorioView(filtrosAtuais),
      registros: this.registroProducaoService.listarTodosCompleta()
    })
      .subscribe({
        next: ({ relatorio, registros }) => {
          const relatorioComRegistros = this.aplicarDadosRegistroProducao(relatorio, registros, filtrosAtuais);
          this.relatorio.set(relatorioComRegistros);
          this.carregando.set(false);
          setTimeout(() => this.renderGraficos());
        },
        error: err => {
          console.error(err);
          this.carregando.set(false);
        }
      });
  }

  private aplicarDadosRegistroProducao(
    relatorioBase: RelatorioView,
    registros: RegistroProducaoDetalhadoDto[],
    filtros: RelatorioQuery
  ): RelatorioView {
    const registrosFiltrados = this.filtrarRegistros(registros, filtros);

    const rankingFuncionarioMap = new Map<string, { id: string; nome: string; pecas: number }>();
    const analitico: RelatorioView['analitico'] = [];

    registrosFiltrados.forEach(registro => {
      const funcionario = registro.funcionario;
      if (funcionario?.id) {
        const atual = rankingFuncionarioMap.get(funcionario.id) ?? {
          id: funcionario.id,
          nome: funcionario.nome ?? '-',
          pecas: 0
        };
        atual.pecas += 1;
        rankingFuncionarioMap.set(funcionario.id, atual);
      }

      analitico.push({
        maquina: registro.maquina?.nome ?? '-',
        funcionario: registro.funcionario?.nome ?? '-',
        peca: registro.peca?.nome ?? '-'
      });
    });

    return {
      ...relatorioBase,
      producaoFuncionario: [...rankingFuncionarioMap.values()].sort((a, b) => b.pecas - a.pecas),
      analitico
    };
  }

  private filtrarRegistros(registros: RegistroProducaoDetalhadoDto[], filtros: RelatorioQuery): RegistroProducaoDetalhadoDto[] {
    const dataInicio = filtros.dataInicio ? new Date(filtros.dataInicio).getTime() : undefined;
    const dataFinal = filtros.dataFinal ? new Date(filtros.dataFinal).getTime() : undefined;

    return (registros ?? []).filter(registro => {
      const dataRegistro = registro.dataInicio ? new Date(registro.dataInicio).getTime() : undefined;

      if (dataRegistro !== undefined && Number.isFinite(dataRegistro)) {
        if (dataInicio !== undefined && Number.isFinite(dataInicio) && dataRegistro < dataInicio) return false;
        if (dataFinal !== undefined && Number.isFinite(dataFinal) && dataRegistro > dataFinal) return false;
      }

      if (filtros.turno && registro.funcionario?.turno !== filtros.turno) return false;

      if (filtros.funcionario?.length && !filtros.funcionario.includes(registro.funcionario?.id ?? '')) return false;
      if (filtros.maquina?.length && !filtros.maquina.includes(registro.maquina?.id ?? '')) return false;
      if (filtros.codigoDesenho?.length && !filtros.codigoDesenho.includes(registro.peca?.codigoDesenho ?? '')) return false;

      return true;
    });
  }

  renderGraficos() {
    const data = this.relatorio();
    if (!data) return;
    if (!this.graficoMaquinasRef?.nativeElement || !this.graficoFuncionariosRef?.nativeElement) return;

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

  atualizarFiltro(campo: string, valor: any) {
    if (campo === 'dataInicio' || campo === 'dataFinal') {
      const d = new Date(valor);
      const isDataFinal = campo === 'dataFinal';
      valor = new Date(Date.UTC(
        d.getFullYear(),
        d.getMonth(),
        d.getDate(),
        isDataFinal ? 23 : 0,
        isDataFinal ? 59 : 0,
        isDataFinal ? 59 : 0,
        isDataFinal ? 999 : 0
      )).toISOString();
    }

    if (campo === 'funcionario' || campo === 'maquina' || campo === 'codigoDesenho') {
      if (Array.isArray(valor)) {
        valor = valor.filter(v => !!v);
      } else if (!valor) {
        valor = [];
      }
    }

    this.filtros.update(f => ({ ...f, [campo]: valor }));
  }

  exportar() {
    console.log("Exportando PDF futuramente", this.relatorio());
  }
}
