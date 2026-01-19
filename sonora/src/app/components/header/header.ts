import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterLink } from "@angular/router";
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [
    MatButtonModule,
    MatCardModule,
    MatToolbarModule,
    RouterLink
],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
}
