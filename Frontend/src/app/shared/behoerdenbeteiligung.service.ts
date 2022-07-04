import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Involments} from "../Entities/Involments";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BehoerdenbeteiligungService {

  url: string = 'http://localhost:8080/involvements';
  private httpHeader: HttpHeaders = new HttpHeaders().append('Content-Type', 'application/json');

  constructor(private http: HttpClient) { }

  public setInvolvements(data: Involments): Observable<Involments>{
    return this.http.post<Involments>(this.url,data,{headers: this.httpHeader});
  }
  public updateInvolvements(data: Involments): Observable<boolean>{
    return this.http.put<boolean>(this.url+"/"+data.id,data,{headers: this.httpHeader})
  }
  public deleteInvolvements(id: number): Observable<Involments>{
    return this.http.delete<Involments>(this.url+"/"+id);
  }

}
