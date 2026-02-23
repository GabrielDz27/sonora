import { Component } from '@angular/core';
import {NavComponent} from '../nav/nav.component';
import {RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-shell',
  standalone: true,
  imports: [NavComponent, RouterOutlet],
  templateUrl: './shell.component.html',
  styleUrl: './shell.component.css'
})
export class ShellComponent {

}
