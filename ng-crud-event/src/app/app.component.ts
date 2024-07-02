import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { EventComponent } from './components/event/event.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, EventComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.sass'
})
export class AppComponent {
  title = 'ng-crud-event';
}
