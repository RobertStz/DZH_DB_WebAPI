import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Authority} from "../Entities/Authority";
import {Message} from "../Entities/Message";
import {Process} from "../Entities/Process";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class VorgangsService {

  url: string = '\'http://localhost:8080/processes'
  private httpHeader: HttpHeaders = new HttpHeaders().append('Content-Type', 'application/json');

  constructor(private http: HttpClient) { }

  public setProcess(data: Process): Observable<Process>{
    return this.http.post<Process>(this.url,data, {headers: this.httpHeader})
  }
  public getProcess(id: number): Observable<Process>{
    return this.http.get<Process>(this.url+"/"+id);
  }
  public deleteProcess(id: number): Observable<Process> {
    return this.http.delete<Process>(this.url + "/" + id);
  }

  public updateProcess(data: Process): Observable<boolean>{
    return this.http.put<boolean>(this.url+"/"+data.id,data,{headers: this.httpHeader})
  }

  public getProcessMessages(id: number): Observable<Message[]>{
    return this.http.get<Message[]>(this.url+"/"+id+"/messages");
  }
  public getProcessAuthorities(id: number): Observable<Authority[]>{
    return this.http.get<Authority[]>(this.url+"/"+id+"/authorities");
  }
}
