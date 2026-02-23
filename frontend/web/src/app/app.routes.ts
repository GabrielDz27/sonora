import { Routes } from '@angular/router';
import { ShellComponent } from './core/layout/shell/shell.component';
import { authGuard } from './core/guards/auth-guard';

export const routes: Routes = [
    // Rotas públicas
    {
        path: 'login',
        loadComponent: () =>
            import('./features/login/login.component').then((m) => m.LoginComponent),
    },

    {
        path: '',
        component: ShellComponent,
        children: [
            { path: '', pathMatch: 'full', redirectTo: 'painel' },

            // Inicio
            {
                path: 'inicio',
                canActivate: [authGuard],
                loadComponent: () =>
                    import('./features/home/home.component').then((m) => m.HomeComponent),
            },
            
            // Funcionario
            {
                path: 'funcionario',
                canActivate: [authGuard],
                loadComponent: () =>
                import('./features/funcionario/funcionario.component').then(
                    (m) => m.FuncionarioComponent),
            },
            
            // Maquina
            {
                path: 'maquina',
                canActivate: [authGuard],
                loadComponent: () =>
                import('./features/maquina/maquina.component').then(
                    (m) => m.MaquinaComponent),
            },
            
            // Peca
            {
                path: 'peca',
                canActivate: [authGuard],
                loadComponent: () =>
                import('./features/peca/peca.component').then(
                    (m) => m.PecaComponent),
            },
            
            // Registro de produção
            {
                path: 'registro-producao',
                canActivate: [authGuard],
                loadComponent: () =>
                import('./features/registro-producao/registro-producao.component').then(
                    (m) => m.RegistroProducaoComponent),
            },
        ]
    },
    {
        path: '**',
        loadComponent: () =>
            import('./features/not-found/not-found.component').then((m) => m.NotFoundComponent),
    },

];
