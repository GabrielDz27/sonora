import { Component, signal, computed, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LucideAngularModule, Activity, Cpu, Package, AlertOctagon, TrendingUp, Clock } from 'lucide-angular/src/icons';
import { RouterLink } from "@angular/router";
import { RegistroProducaoService } from '../../services/registro-producao.service';
import { PecaService } from '../../services/peca.service';
import { MaquinaService } from '../../services/maquina.service';
import { FuncionarioService } from '../../services/funcionario.service';
import { forkJoin } from 'rxjs';

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
    forkJoin({
      registros: this.registroProducaoService.listarTodosCompleta(),
      maquinas: this.maquinaService.listarTodos(),
      pecas: this.pecaService.listarTodos()
    }).subscribe(({ registros, maquinas, pecas }) => {

      // produção em andamento
      this.pecasEmProcesso.set(registros.filter(r => !r.dataFinal).length);

      // produção concluída
      this.producaoDia.set(registros.filter(r => r.dataInicio && r.dataFinal).length);

      // ultima atualização
      if (registros.length) {
        const maisRecente = registros.reduce((a, b) =>
          new Date(a.dataInicio) > new Date(b.dataInicio) ? a : b
        );

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

      // maquinas
      this.totalMaquinas.set(maquinas.length);
      this.maquinasAtivas.set(maquinas.filter(m => m.status === 'ATIVO').length);

      // peças mortas
      this.pecasMorta.set(pecas.filter(p => p.status === 'MORTA').length);
    });
  }

  carregarAtividades() {
    this.registroProducaoService.listarTodosCompleta()
      .subscribe(registros => {

        this.atividades.set(
          registros
            .slice(-10)
            .reverse()
            .map((r, idx) => ({
              id: r.id ?? idx,
              peca: r.peca.nome,
              operador: r.funcionario.nome,
              maquina: r.maquina.nome,
              status: r.dataFinal ? 'FINALIZADO' : 'PRODUZINDO',
              tempo: this.calcularTempo(r.dataInicio, r.dataFinal)
            }))
        );
      });
  }

  private calcularTempo(inicio: string, fim?: string): string {
    if (!inicio) return '--';

    const start = new Date(inicio).getTime();
    const end = fim ? new Date(fim).getTime() : Date.now();

    const minutos = Math.floor((end - start) / 60000);
    const horas = Math.floor(minutos / 60);
    const mins = minutos % 60;

    return `${horas}h ${mins}m`;
  }
}
