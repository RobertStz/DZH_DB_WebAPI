import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import {Router} from "@angular/router";
import {LoginService} from "../Services/login.service";

@Injectable({
  providedIn: 'root'
})
export class AuthServiceGuard implements CanActivate {

  constructor(private log: LoginService, private router: Router) {
  }

  canActivate():boolean {

    if (!this.log.isLoggedIn()){
      this.router.navigate(['']);
      return false;
    }
    return true;
  }

}
