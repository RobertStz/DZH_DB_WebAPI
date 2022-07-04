import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "../shared/login.service";
import {CitizenService} from "../shared/citizen.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {


  constructor(private router: Router, private log: LoginService, private user: CitizenService) { }

  ngOnInit(): void {
    this.user.getCitizenKids(Number(this.user.myStorage.getItem('key'))).subscribe(connectedUser => {

    })
  }

  title = 'Digitales Zuhause';

  goToHomepage($event: MouseEvent){
    this.router.navigate(['/index'])
  }

  goToProfil($event: MouseEvent){
    this.router.navigate(['/index/Profile'])
  }

  goToTasks($event: MouseEvent){
    this.router.navigate(['/index/tasks'])
  }

  goToLinkedProfil($event: MouseEvent){
    this.router.navigate([''])
  }

  logOut($event: MouseEvent){
    this.log.myStorage.removeItem('key');
    this.router.navigate(['']);
  }
}
