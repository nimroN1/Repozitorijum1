import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {

  private hotels:Hotel[] = [];

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get<Hotel[]>('http://localhost:8080/api/hotel/all').subscribe((data)=>{
      this.hotels = data;
      console.log(this.hotels);


    });
  }

}
