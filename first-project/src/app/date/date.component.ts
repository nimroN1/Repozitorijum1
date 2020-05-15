import { Component, OnInit, Input } from '@angular/core';
import { Student } from '../model/Student';

@Component({
  selector: 'app-date',
  templateUrl: './date.component.html',
  styleUrls: ['./date.component.css']
})
export class DateComponent implements OnInit {

  currentDate:String;
  currentStudent:Student;

  @Input('myTitle')
  mojNaslov:String;

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
/*     this.currentStudent.tel.push("065-111-222");
    this.currentStudent.tel.push("055-555-666"); */
    console.log("Current student: ");
    console.log(this.currentStudent);

    for(let item of this.currentStudent.tel){
      console.log(item);
    }

    let i;
    for(i=0; i<this.currentStudent.tel.length; i++){
      console.log(this.currentStudent.tel[i]);
    }

  }

  public saberiDvaBroja(x:number, y:number): number{
    return x+y;
  }

  public logName(){
    console.log(this.currentStudent.ime);
  }

}
