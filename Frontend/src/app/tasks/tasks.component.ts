import { Component, OnInit } from '@angular/core';
import {LoginService} from "../shared/login.service";
import {CitizenService} from "../shared/citizen.service";

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  constructor(private log: LoginService, private user: CitizenService) { }
  title = this.user.myStorage.getItem('name');

  openPro: any []=[];

  ngOnInit(): void {
    this.user.getCitizenProcesses(Number(this.log.myStorage.getItem('key'))).subscribe( userProcesses =>{
      for (let i = 0; i < userProcesses.length; i++){
        this.openPro.push(userProcesses[i]);
      }
    })
  }

  popup: boolean = false;
  openPopup($event: MouseEvent){
      this.popup = true;
  }

}
