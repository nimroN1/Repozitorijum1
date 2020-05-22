import { Component } from '@angular/core';
import { Student } from './model/Student';
import { CustomWriteServiceService } from 'src/custom-write-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  student1:Student;

  title = 'first-project';

  constructor(private cws:CustomWriteServiceService){

  }

  ngOnInit(): void {
    this.student1=new Student();
    this.student1.ime="Marko";
    this.student1.prezime="Marković";
    this.student1.tel.push("065-111-222");
    this.student1.tel.push("055-555-666"); 

    this.cws.simpleLog("Hello from service!");
  }
}
