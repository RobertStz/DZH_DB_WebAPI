import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Citizen} from "../Entities/Citizen";
import {Process} from "../Entities/Process";
import {Message} from "../Entities/Message";
import {Authority} from "../Entities/Authority";
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
  public logInCitizen(user: string, password: string): Observable<any>{
    const parameters = new HttpParams().append('email',user).append('password',password);
    return this.http.get<any>(this.url,{params: parameters});
  }
  public getCitizenProcesses(id: number): Observable<Process>{
    return this.http.get<Process>(this.url+"/"+id+"/processes");
  }
  public getCitizenMessages(id: number): Observable<Message>{
    return this.http.get<Message>(this.url+"/"+id+"/messages");
  }
  public getCitizenKids(id: number): Observable<Citizen>{
    return this.http.get<Citizen>(this.url+"/"+id+"/kids");
  }
  public getCitizenAuthorities(id: number): Observable<Authority>{
    return this.http.get<Authority>(this.url+"/"+id+"/authorities");
  }
  public deleteCitizen(id: number): Observable<Citizen>{
    return this.http.delete<Citizen>(this.url+"/"+id)
  }
  public getCitizen(id: number): Observable<Citizen>{
    return this.http.get<Citizen>(this.url+"/"+id);
  }
  public updateCitizen(data: Citizen): Observable<Citizen>{
    return this.http.post<Citizen>(this.url+"/"+data.id,data,{headers: this.httpHeader});
  }

}
