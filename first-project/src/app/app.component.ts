import { Component } from '@angular/core';
import { Student } from './model/Student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  student1:Student;

  title = 'first-project';

  ngOnInit(): void {
    this.student1=new Student();
    this.student1.ime="Marko";
    this.student1.prezime="Marković";
    this.student1.tel.push("065-111-222");
    this.student1.tel.push("055-555-666"); 
  }
}
