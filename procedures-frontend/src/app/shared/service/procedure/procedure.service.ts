import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Procedure} from '../../constant/procedure';

@Injectable({
  providedIn: 'root'
})
export class ProcedureService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  addProcedure(procedure: Procedure): Observable<String> {
    return this.http.post<String>(this.baseUrl + '/procedure', procedure);
  }

  getAllProcedures(): Observable<Procedure[]> {
    return this.http.get<Procedure[]>(this.baseUrl + '/procedures');
  }
}
