import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  title = 'Digitales Zuhause';

  goToHomepage($event: MouseEvent){
    this.router.navigate(['/index'])
  }

  goToProfil($event: MouseEvent){
    this.router.navigate([''])
  }

  goToTasks($event: MouseEvent){
    this.router.navigate(['/index/tasks'])
  }

  goToLinkedProfil($event: MouseEvent){
    this.router.navigate([''])
  }

  logOut($event: MouseEvent){
    this.router.navigate([''])
  }
}
