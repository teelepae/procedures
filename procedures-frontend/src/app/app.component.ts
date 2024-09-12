import { Component } from '@angular/core';
import {ProceduresTableComponent} from './procedures-table/procedures-table.component';
import {ProcedureFormComponent} from './procedure-form/procedure-form.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ProceduresTableComponent, ProcedureFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  public title = 'procedures-frontend';
  public procedureSaved: boolean = false;

    public formSaved($event: boolean) {
      this.procedureSaved = $event;
    }

    public noEvents() {
      this.procedureSaved = false;
    }
}
