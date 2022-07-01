import { Injectable } from '@angular/core';
import {Citizen} from "../../Entities/Citizen";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CitizenService {

  url: string = 'http://localhost:8080/citizens';

  constructor() { }

  public setCitizen(data: Citizen): Observable<Citizen>{

  }



}
