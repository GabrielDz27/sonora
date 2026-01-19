import { Component } from '@angular/core';
import { Banner } from '../../components/banner/banner';
import { Container } from '../../components/container/container';
import { Footer } from "../../components/footer/footer";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [Banner, Container, Footer],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {

}
