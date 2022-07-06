import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CitizenService} from "../shared/citizen.service";
import {HttpErrorResponse} from "@angular/common/http";
import {LoginService} from "../shared/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private user: CitizenService,private log: LoginService) { }

  ngOnInit(): void {
  }

  login($event: MouseEvent): void{
    this.user.logInCitizen((document.getElementById('emailInput') as HTMLInputElement).value,(document.getElementById('passwordInput') as HTMLInputElement).value).subscribe( data =>{
      this.log.myStorage.setItem('key',String(data.id))
      this.user.myStorage.setItem('name',data.firstName+" "+ data.name)
      this.router.navigate(['index'])
    }, (err: HttpErrorResponse) =>{
      switch (err.status){
        case 500:
          alert("Anmeldung momentan nicht verfügbar");
          break;
        case 403:
          alert("Passwort oder E-Mail falsch");
          break;
        case 404:
          alert("Konto existiert noch nicht! \n Bitte Registrieren Sie sich zuerst ");
          break;
      }
    });


  }

}
