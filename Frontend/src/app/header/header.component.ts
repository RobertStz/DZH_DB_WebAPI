import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "../shared/login.service";
import {CitizenService} from "../shared/citizen.service";
import {Citizen} from "../Entities/Citizen";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  showParents: boolean = false;

  constructor(private router: Router, private log: LoginService, private user: CitizenService) { }

  ngOnInit(): void {
    this.user.getCitizenKids(Number(this.user.myStorage.getItem('key'))).subscribe(connectedUser => {

    })

    this.user.getCitizen(Number(this.user.myStorage.getItem('key'))).subscribe(loggedIn =>{
      if(loggedIn.firstName == 'Max'){
        this.showParents = true;
      }else if(loggedIn.firstName == 'Julia'){
        this.showParents = false;
      }else if(loggedIn.firstName == 'Klaus'){
        this.showParents = false;
      }
    })

  }

  title = 'Digitales Zuhause';

  goToHomepage($event: MouseEvent){
    this.router.navigate(['/index/'])
  }

  goToProfil($event: MouseEvent){
    this.router.navigate(['/index/Profile'])
  }

  goToTasks($event: MouseEvent){
    this.router.navigate(['/index/tasks'])
  }

  goToLinkedKidsProfil($event: MouseEvent, name: string){
    this.user.getCitizenKids(Number(this.user.myStorage.getItem('key'))).subscribe(linkedK => {
      for (let i = 0; i < linkedK.length; i++) {
        if(name == linkedK[i].firstName) {
          this.user.logInCitizen(linkedK[i].email, linkedK[i].password).subscribe(logIn => {
            this.user.myStorage.setItem('key', String(linkedK[i].id));
            this.user.myStorage.setItem('name',logIn.firstName+" "+ logIn.name)
            this.showParents = true;
            this.navigate();
          })
        }
      }
    })

  }

  goToLinkedMothersProfil($event: MouseEvent){
    this.user.getCitizen(Number(this.user.myStorage.getItem('key'))).subscribe(parentM =>{
      this.user.getCitizen(Number(parentM.mother.id)).subscribe(linkedM =>{
        this.user.logInCitizen(linkedM.email, linkedM.password).subscribe(logIn =>{
          this.user.myStorage.setItem('key', String(linkedM.id));
          this.user.myStorage.setItem('name',linkedM.firstName+" "+ linkedM.name)
          this.showParents = false;
          this.navigate();
        })
      })
    })
  }

  goToLinkedFathersProfil($event: MouseEvent){
    this.user.getCitizen(Number(this.user.myStorage.getItem('key'))).subscribe(parentF =>{
      this.user.getCitizen(Number(parentF.father.id)).subscribe(linkedF =>{
        this.user.logInCitizen(linkedF.email, linkedF.password).subscribe(logIn =>{
          this.user.myStorage.setItem('key', String(linkedF.id));
          this.user.myStorage.setItem('name',linkedF.firstName+" "+ linkedF.name)
          this.showParents = false;
          this.navigate();
        })
      })
    })
  }

  navigate(){
    this.router.navigate(['/index/']);
  }

  logOut($event: MouseEvent){
    this.log.myStorage.removeItem('key');
    this.router.navigate(['']);
  }
}
