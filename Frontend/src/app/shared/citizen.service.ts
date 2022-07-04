import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Citizen} from "../Entities/Citizen";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CitizenService {

  url: string = 'http://localhost:8080/citizens';
  private httpHeader: HttpHeaders = new HttpHeaders().append('Content-Type', 'application/json');

  constructor(private http: HttpClient) { }

  //Add a ne Citizen
  public setCitizen(data: Citizen): Observable<Citizen>{
    return this.http.post<Citizen>(this.url,data,{headers: this.httpHeader});
  }

  //Login Request to log in
  public logInCitizen(user: string, password: string): Observable<Citizen>{
    const parameters = new HttpParams().append('email',user).append('password',password);
    return this.http.get<Citizen>(this.url,{params: parameters});
  }




}
