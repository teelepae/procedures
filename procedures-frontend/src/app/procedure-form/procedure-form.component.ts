import { Component, EventEmitter, OnDestroy, Output } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators, ReactiveFormsModule} from '@angular/forms';
import {ProcedureService} from '../shared/service/procedure/procedure.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'procedure-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './procedure-form.component.html',
  styleUrl: './procedure-form.component.scss'
})
export class ProcedureFormComponent implements OnDestroy {
  @Output() saveEvent = new EventEmitter();
  private procedureSubscription: Subscription = new Subscription;
  public procedureForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private procedureService: ProcedureService) {
    this.procedureForm = this.formBuilder.group({
      firstName: new FormControl(''),
      lastName: new FormControl(''),
      idCode:  new FormControl(''),
      email: new FormControl('', [Validators.required, Validators.pattern(/^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/)]),
      reason: new FormControl('')
    });
  }

  public addProcedure(): void {
    this.procedureSubscription = this.procedureService.addProcedure(this.procedureForm.value).subscribe((data) => {
       this.saveEvent.emit(true);
    });
  }

  ngOnDestroy(): void {
    this.procedureSubscription.unsubscribe();
  }
}
