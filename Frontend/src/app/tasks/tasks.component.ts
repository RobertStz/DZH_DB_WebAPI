import { Component, OnInit } from '@angular/core';
import {LoginService} from "../shared/login.service";
import {CitizenService} from "../shared/citizen.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  constructor(private log: LoginService, private user: CitizenService, private router: Router) { }
  title = this.user.myStorage.getItem('name');

  data: any []=[];

  ngOnInit(): void {
    this.user.getCitizenProcesses(Number(this.log.myStorage.getItem('key'))).subscribe( userProcesses =>{
      for (let i = 0; i < userProcesses.length; i++){
        this.data.push(userProcesses[i]);
      }
    })
  }

  goToDecision($event: MouseEvent, id: number){
    this.user.myStorage.setItem('processID', String(id));
    this.router.navigate(['/index/Decision']);
  }

}
