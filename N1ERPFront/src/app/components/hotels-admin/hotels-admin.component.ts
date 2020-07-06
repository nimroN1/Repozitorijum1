import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { HttpClient } from '@angular/common/http';
import { MessageResponse } from 'src/app/model/MessageResponse';

@Component({
  selector: 'app-hotels-admin',
  templateUrl: './hotels-admin.component.html',
  styleUrls: ['./hotels-admin.component.css']
})
export class HotelsAdminComponent implements OnInit {

  hotels:Hotel[] = [];
  newHotel:Hotel = new Hotel();
  

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.loadHotels();
  }

  public addHotel(){
    this.http.post<Hotel>('http://localhost:8080/api/hotel', this.newHotel).subscribe((data) => {
      this.loadHotels();
      this.newHotel = new Hotel();
    });
  }

  public removeHotel(id:number){
    this.http.delete<MessageResponse>('http://localhost:8080/api/hotel/'+id).subscribe((data) => {
      this.loadHotels();
      alert(data.message);
      //this.newHotel = new Hotel();
    });
  }

  public loadHotels(){
    this.http.get<Hotel[]>('http://localhost:8080/api/hotel/all').subscribe((data) => {
      this.hotels = data;
      console.log(this.hotels);
    });
  }

}
