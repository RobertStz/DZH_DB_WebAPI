import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CitizenService} from "../shared/Services/citizen.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private user: CitizenService) { }

  ngOnInit(): void {
  }

  login($event: MouseEvent): void{

    this.user.logInCitizen((document.getElementById('') as HTMLInputElement).value,(document.getElementById('') as HTMLInputElement).value).subscribe( data =>{
      console.log(data)
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
