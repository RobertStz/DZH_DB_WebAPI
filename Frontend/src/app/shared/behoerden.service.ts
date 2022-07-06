import { Injectable } from '@angular/core';
import {Authority} from "../Entities/Authority";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Process} from "../Entities/Process";
import {Message} from "../Entities/Message";
import {Citizen} from "../Entities/Citizen";

@Injectable({
  providedIn: 'root'
})
export class BehoerdenService {

  url: string = 'http://localhost:8080/authorities';
  private httpHeader: HttpHeaders = new HttpHeaders().append('Content-Type', 'application/json');

  constructor(private http: HttpClient) { }

  public setAuthority(behoerde: Authority): Observable<Authority>{
    return this.http.post<Authority>(this.url,behoerde, {headers: this.httpHeader});
  }

  public getAuthorityProcesses(id: number):Observable<Process[]>{
    return this.http.get<Process[]>(this.url+"/"+id+"/processes");
  }
  public getAuthorityMessages(id: number):Observable<Message[]>{
    return this.http.get<Message[]>(this.url+"/"+id+"/messages");
  }
  public getAuthorityCitizen(id: number):Observable<Citizen[]>{
    return this.http.get<Citizen[]>(this.url+"/"+id+"/citizen");
  }
  public updateAuthority(data: Authority):Observable<boolean>{
    return this.http.put<boolean>(this.url+"/"+data.id, data,{headers: this.httpHeader});
  }
  public getSingleAuthority(id: number): Observable<Authority>{
    return this.http.get<Authority>(this.url+"/"+id);
  }


}
