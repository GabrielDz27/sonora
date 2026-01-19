import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { Login } from './pages/login/login';
import { Instrumento } from './pages/instrumento/instrumento';
import { Sala } from './pages/sala/sala';
import { Membro } from './pages/membro/membro';
import { Reserva } from './pages/reserva/reserva';
import { Cadastro } from './pages/cadastro/cadastro';

export const routes: Routes = [
    { 
        path: '', 
        component: Home
    },
    {
        path: 'login',
        component: Login
    },
    {
        path: 'instrumentos',
        component: Instrumento
    },
    {
        path: 'salas',
        component: Sala
    },
    {
        path: 'membros',
        component: Membro
    },
    {
        path: 'reservas',
        component: Reserva
    },
    {
        path: 'cadastro',
        component: Cadastro
    }
];
