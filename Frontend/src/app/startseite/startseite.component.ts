import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-startseite',
  templateUrl: './startseite.component.html',
  styleUrls: ['./startseite.component.css']
})
export class StartseiteComponent implements OnInit {

  constructor() { }

  title = '❤-lich Willkommen im Digitalen Zuhause von '+' ';

  ngOnInit(): void {
  }

}
