import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "../shared/login.service";
import {Citizen} from "../Entities/Citizen";
import {CitizenService} from "../shared/citizen.service";
import {Gender} from "../Entities/Gender";
import {Address} from "../Entities/Address";

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

  //Daten zum Bürger
  email: string = '';
  password: string = '';



  ngOnInit(): void {
    this.user.getCitizen(Number(this.log.myStorage.getItem('key'))).subscribe(userData =>{

      (document.getElementById('firstname') as HTMLInputElement).value = userData.firstName;
      (document.getElementById('lastname') as HTMLInputElement).value = userData.name;
      (document.getElementById('birthCountry') as HTMLInputElement).value = userData.birthCountry;
      (document.getElementById('birthPlace') as HTMLInputElement).value = userData.birthPlace;
      (document.getElementById('steuernum') as HTMLInputElement).value = userData.taxId;
      (document.getElementById('street') as HTMLInputElement).value = userData.address.street + " " + userData.address.streetNumber;
      (document.getElementById('city') as HTMLInputElement).value = userData.address.postcode + " " + userData.address.city;
      let dateUser = new Date(userData.birthday);
      console.log(dateUser);
      (document.getElementById('birthDay') as HTMLInputElement).value = String(dateUser.toLocaleDateString());

      (document.getElementById('email') as HTMLInputElement).value = userData.email;
      (document.getElementById('password') as HTMLInputElement).value = userData.password;

    });

  }

  changeData($event: MouseEvent){
    this.changeLoginData = true;
    this.change = false;
    this.save = true;
  }

  saveData($event: MouseEvent){
    this.email = (document.getElementById('email') as HTMLInputElement).value;
    this.password = (document.getElementById('password') as HTMLInputElement).value;

    this.user.getCitizen(Number(this.log.myStorage.getItem('key'))).subscribe(citizen =>{
      citizen.email = this.email;
      citizen.password = this.password;
      this.user.updateCitizen(citizen).subscribe(update =>{});
    })

    this.changeLoginData = false;
    this.change = true;
    this.save = false;
  }

  goBack($event: MouseEvent){
    this.router.navigate(['/index'])
  }
}
