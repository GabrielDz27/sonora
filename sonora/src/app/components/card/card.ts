import { Component, Input } from '@angular/core';
import { NgClass } from "../../../../node_modules/@angular/common/types/_common_module-chunk";

@Component({
  selector: 'app-card',
  imports: [NgClass],
  templateUrl: './card.html',
  styleUrl: './card.css',
})
export class Card {
  @Input() variant: 'primary' | 'secondary' = 'primary'
}
