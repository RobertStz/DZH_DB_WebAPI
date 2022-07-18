import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {VorgangsService} from "../shared/vorgangs.service";
import {CitizenService} from "../shared/citizen.service";
import {BehoerdenbeteiligungService} from "../shared/behoerdenbeteiligung.service";

@Component({
  selector: 'app-decision',
  templateUrl: './decision.component.html',
  styleUrls: ['./decision.component.css']
})
export class DecisionComponent implements OnInit {

  permission: string = '';

  constructor(private router: Router, private process: VorgangsService, private user: CitizenService, private involvements: BehoerdenbeteiligungService) { }

  ngOnInit(): void {
    this.process.getProcessInvolvements(Number(this.user.myStorage.getItem('processID'))).subscribe(process =>{
      for(let j = 0; j < process.length;j++){
        if(process[j].id == Number(this.user.myStorage.getItem('processID'))){
          (document.getElementById('gettingAuth') as HTMLInputElement).value = process[j].targetAuthority.name;
          (document.getElementById('sendingAuth') as HTMLInputElement).value = process[j].sourceAuthority.name;
          this.permission = process[j].permission;
        }
      }

    })

  }

  decision($event: MouseEvent, decision: string){
    this.process.getProcessInvolvements(Number(this.user.myStorage.getItem('processID'))).subscribe(process =>{
      for(let i = 0; i < process.length; i++){
        process[i].permission = decision;
        this.involvements.setInvolvements(process[i]).subscribe(update=>{});
      }
    })
  }

  goBack($event: MouseEvent){
    this.router.navigate(['/index/tasks'])
  }
}
