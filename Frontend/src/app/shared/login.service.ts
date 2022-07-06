import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  myStorage = sessionStorage;
  constructor() { }

  public isLoggedIn():boolean {
    if(this.myStorage.getItem('key') !== null){
      return true;
    }else{
      return false;
    }
  }

}
