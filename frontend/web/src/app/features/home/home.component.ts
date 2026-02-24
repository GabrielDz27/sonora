import { Component, signal, computed, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LucideAngularModule, Activity, Cpu, Package, AlertOctagon, TrendingUp, Clock } from 'lucide-angular/src/icons';
import { RouterLink } from "@angular/router";
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, LucideAngularModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  pecasEmProcesso = signal(12);
  maquinasAtivas = signal(5);
  totalMaquinas = signal(8);
  producaoDia = signal(45);
  pecasMorta = signal(2);

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
  atividades = signal([
    { id: 1, peca: 'Eixo Traseiro G2', operador: 'João Silva', maquina: 'Torno 01', status: 'PRODUZINDO', tempo: '14min' },
    { id: 2, peca: 'Engrenagem H4', operador: 'Ana Souza', maquina: 'Fresa 02', status: 'FINALIZADO', tempo: '45min' },
    { id: 3, peca: 'Pino de Trava', operador: 'Carlos Lima', maquina: 'CNC 03', status: 'MORTA', tempo: '5min' },
  ]);
}
