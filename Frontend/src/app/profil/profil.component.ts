import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  constructor(private router: Router) { }

  changeLoginData = false;
  change = true;
  save = false;

  ngOnInit(): void {
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
