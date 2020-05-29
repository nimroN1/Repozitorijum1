import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Student } from '../model/Student';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  id:String;
  studenti:Student[] = [];

  constructor(private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params =>{
      this.id = params.get('id');
    });

    let s1 = new Student();
    s1.ime = 'Petar';
    s1.prezime = 'Petrović';
    s1.brIndexa = 1234;
    s1.tel.push('065/222-333');

    this.studenti.push(s1);

    let s2 = new Student();
    s2.ime = 'Marko';
    s2.prezime = 'Marković';
    s2.brIndexa = 4567;
    s2.tel.push('065/444-333');

    this.studenti.push(s2);
  }

}
