import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ButtonComponent } from '../../shared/ui/button/button.component';
import { LucideAngularModule } from 'lucide-angular/src/icons';

@Component({
  selector: 'app-not-found',
  imports: [ButtonComponent, RouterLink, RouterLink, LucideAngularModule],
  templateUrl: './not-found.component.html'
})
export class NotFoundComponent {

}
