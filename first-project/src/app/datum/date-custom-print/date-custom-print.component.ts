import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-date-custom-print',
  templateUrl: './date-custom-print.component.html',
  styleUrls: ['./date-custom-print.component.css']
})
export class DateCustomPrintComponent implements OnInit {

  public _trenutniDatum: Date = new Date();
  

  constructor() { }

  ngOnInit(): void {
  }

}
