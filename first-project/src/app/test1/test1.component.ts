import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test1',
  templateUrl: './test1.component.html',
  styleUrls: ['./test1.component.css']
})
export class Test1Component implements OnInit {

  constructor() {

   }

  ngOnInit(): void {
  }

  public method1(){
    localStorage.setItem("testItem1", "Hello");
    console.log(localStorage.getItem("testItem1"));
  }

}
