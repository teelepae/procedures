import {Component, EventEmitter, Input, OnInit, OnChanges, OnDestroy, Output, SimpleChanges} from '@angular/core';
import {Procedure} from '../shared/constant/procedure';
import {ProcedureService} from '../shared/service/procedure/procedure.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'procedures-table',
  standalone: true,
  imports: [],
  templateUrl: './procedures-table.component.html',
  styleUrl: './procedures-table.component.scss'
})
export class ProceduresTableComponent implements OnChanges, OnInit, OnDestroy {
  @Input() procedureSaved = false;
  @Output() refreshEndedEvent = new EventEmitter();
  private proceduresSubscription: Subscription = new Subscription;
  public procedureList: Procedure[] = [];

  constructor(private procedureService: ProcedureService){}

    ngOnChanges(changes: SimpleChanges): void {
      if (changes['procedureSaved']) {
        this.getProcedures();
        this.refreshEndedEvent.emit();
      }
    }

  ngOnInit(): void {
    this.getProcedures();
  }

  private getProcedures(): void {
    this.proceduresSubscription = this.procedureService.getAllProcedures().subscribe((procedures) => {
      this.procedureList = procedures;
    });
  }

  ngOnDestroy(): void {
    this.proceduresSubscription.unsubscribe();
  }
}
