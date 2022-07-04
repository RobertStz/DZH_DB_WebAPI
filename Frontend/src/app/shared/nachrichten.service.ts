import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Message} from "../Entities/Message";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NachrichtenService {

  url: string = 'http://localhost:8080/messages';
  private httpHeader: HttpHeaders = new HttpHeaders().append('Content-Type', 'application/json');

  constructor(private http: HttpClient) { }

  public getMessage(id: number):Observable<Message>{
    return this.http.get<Message>(this.url+"/"+id);
  }
  public setMessage(data: Message):Observable<Message>{
    return this.http.post<Message>(this.url,data,{headers: this.httpHeader});
  }
  public deleteMessage(id: number):Observable<Message>{
    return this.http.delete<Message>(this.url+"/"+id);
  }
  public updateMessage(data: Message):Observable<boolean>{
    return this.http.put<boolean>(this.url+"/"+data.id,data,{headers: this.httpHeader});
  }
}
