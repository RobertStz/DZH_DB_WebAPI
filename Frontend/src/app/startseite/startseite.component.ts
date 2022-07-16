import { Component, OnInit } from '@angular/core';
import {CitizenService} from "../shared/citizen.service";

@Component({
  selector: 'app-startseite',
  templateUrl: './startseite.component.html',
  styleUrls: ['./startseite.component.css']
})
export class StartseiteComponent implements OnInit {

  constructor(private user: CitizenService) { }

  title = '❤-lich Willkommen im Digitalen Zuhause von '+this.user.myStorage.getItem('name');

  ngOnInit(): void {
  }

}
