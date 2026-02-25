import { Component, signal, computed, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LucideAngularModule, Activity, Cpu, Package, AlertOctagon, TrendingUp, Clock } from 'lucide-angular/src/icons';
import { RouterLink } from "@angular/router";
import { RegistroProducaoService } from '../../services/registro-producao.service';
import { PecaService } from '../../services/peca.service';
import { MaquinaService } from '../../services/maquina.service';
import { FuncionarioService } from '../../services/funcionario.service';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, LucideAngularModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  private registroProducaoService = inject(RegistroProducaoService);
  private pecaService = inject(PecaService);
  private maquinaService = inject(MaquinaService);
  private funcionarioService = inject(FuncionarioService);

  pecasEmProcesso = signal(0);
  maquinasAtivas = signal(0);
  totalMaquinas = signal(0);
  producaoDia = signal(0);
  pecasMorta = signal(0);
  ultimaAtualizacao = signal<string>('');

  readonly Activity = Activity;
  readonly Cpu = Cpu;
  readonly Package = Package;
  readonly AlertOctagon = AlertOctagon;
  readonly TrendingUp = TrendingUp;
  readonly Clock = Clock;

  // Exemplo de KPI calculado
  eficiencia = computed(() => {
    const total = this.producaoDia() + this.pecasMorta();
    return total > 0 ? Math.round((this.producaoDia() / total) * 100) : 0;
  });

  // Lista de atividades recentes
  atividades = signal<any[]>([]);

  ngOnInit() {
    this.carregarKPIs();
    this.carregarAtividades();
  }

  carregarKPIs() {
    this.registroProducaoService.listarTodos().subscribe(registros => {
      this.pecasEmProcesso.set(registros.filter(r => !r.dataFinal).length);
      this.producaoDia.set(registros.filter(r => r.dataInicio && r.dataFinal).length);
      if (registros.length > 0) {
        const maisRecente = registros.reduce((a, b) => {
          const aDate = new Date(a.dataInicio);
          const bDate = new Date(b.dataInicio);
          return aDate > bDate ? a : b;
        });
        this.ultimaAtualizacao.set(
          new Date(maisRecente.dataInicio).toLocaleString('pt-BR', {
            hour: '2-digit',
            minute: '2-digit',
            day: '2-digit',
            month: '2-digit',
            year: 'numeric'
          })
        );
      } else {
        this.ultimaAtualizacao.set('Sem registros');
      }
    });
    this.maquinaService.listarTodos().subscribe(maquinas => {
      this.totalMaquinas.set(maquinas.length);
      this.maquinasAtivas.set(maquinas.filter(m => m.status === 'ATIVO').length);
    });
    this.pecaService.listarTodos().subscribe(pecas => {
      this.pecasMorta.set(pecas.filter(p => p.status === 'MORTA').length);
    });
  }

  carregarAtividades() {
    this.registroProducaoService.listarTodos().subscribe(registros => {
      // Exemplo: pega os últimos 10 registros
      this.atividades.set(
        registros.slice(-10).map((r, idx) => ({
          id: r.id ?? idx,
          peca: r.peca?.id ?? r.peca,
          operador: r.funcionario?.id ?? r.funcionario,
          maquina: r.maquina?.id ?? r.maquina,
          status: r.dataFinal ? 'FINALIZADO' : 'PRODUZINDO',
          tempo: r.dataInicio ? 'N/A' : 'N/A'
        }))
      );
    });
  }
}
