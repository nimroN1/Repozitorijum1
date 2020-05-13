import { Component, OnInit } from '@angular/core';
import { Student } from '../model/Student';

@Component({
  selector: 'app-date',
  templateUrl: './date.component.html',
  styleUrls: ['./date.component.css']
})
export class DateComponent implements OnInit {

  currentDate:String;
  currentStudent:Student;

  constructor() { }

  ngOnInit(): void {
    //this.currentDate = new Date().toString();
    setInterval(()=>{
      let tempDate = new Date();
      this.currentDate = tempDate.toDateString()+" "+tempDate.toLocaleTimeString();
    }, 1000);

    this.currentStudent = new Student();

    this.currentStudent.brIndexa=1;
    this.currentStudent.ime="Mladen";
    this.currentStudent.prezime = "Rosić";
    this.currentStudent.tel.push("065-111-222");
    console.log("Current student: ");
    console.log(this.currentStudent);

  }

  public saberiDvaBroja(x:number, y:number): number{
    return x+y;
  }

}
