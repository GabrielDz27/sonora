import { Component, computed, inject } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { LucideAngularModule, Box, LayoutDashboard, Settings2, Users, Cpu, Activity, BarChart3, LogOut } from 'lucide-angular/src/icons';
import { AutenticacaoService } from '../../../services/auth/autenticacao.service';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { FuncionarioDto } from '../../../models/funcionario.models';
import { toSignal } from '@angular/core/rxjs-interop';


@Component({
  selector: 'app-nav',
  imports: [LucideAngularModule, RouterLink],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {
  readonly Box = Box;
  readonly LayoutDashboard = LayoutDashboard;
  readonly Settings2 = Settings2;
  readonly Users = Users;
  readonly Cpu = Cpu;
  readonly Activity = Activity;
  readonly BarChart3 = BarChart3;
  readonly LogOut = LogOut;

  private auth = inject(AutenticacaoService);
  router = inject(Router);
  
  usuario = toSignal(this.auth.usuarioLogado(), { initialValue: null });
  
  iniciais = computed(() => {
    const user = this.usuario();
    const nome = user?.nome;
    
    if (!nome) return '??';
    const partes = nome.split(' ');
    return (partes[0][0] + (partes.length > 1 ? partes[1][0] : '')).toUpperCase();
  });

  fazerLogout() {
    this.auth.logout();
    this.router.navigate(['/login']); 
  }
}

