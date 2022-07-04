import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "../shared/login.service";
import {Citizen} from "../Entities/Citizen";
import {CitizenService} from "../shared/citizen.service";

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  constructor(private router: Router, private log: LoginService, private user: CitizenService) { }

  changeLoginData = false;
  change = true;
  save = false;

  ngOnInit(): void {
    this.user.getCitizen(Number(this.log.myStorage.getItem('key'))).subscribe(userData =>{

      (document.getElementById('firstname') as HTMLInputElement).value = userData.firstName;
      (document.getElementById('lastname') as HTMLInputElement).value = userData.birthName;
      (document.getElementById('birthCountry') as HTMLInputElement).value = userData.birthCountry;
      (document.getElementById('birthPlace') as HTMLInputElement).value = userData.birthPlace;
      let dateUser = userData.birthDay;
      (document.getElementById('birthDay') as HTMLInputElement).value = String(dateUser.toLocaleDateString());

    });

  }

  changeData($event: MouseEvent){
    this.changeLoginData = true;
    this.change = false;
    this.save = true;
  }

  saveData($event: MouseEvent){
    this.changeLoginData = false;
    this.change = true;
    this.save = false;
  }

  goBack($event: MouseEvent){
    this.router.navigate(['/index'])
  }
}
