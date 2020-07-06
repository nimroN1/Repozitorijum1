import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel } from 'src/app/model/Hotel';
import { MessageResponse } from 'src/app/model/MessageResponse';
import { HotelRoom } from 'src/app/model/HotelRoom';

@Component({
  selector: 'app-hotels-admin-update',
  templateUrl: './hotels-admin-update.component.html',
  styleUrls: ['./hotels-admin-update.component.css']
})
export class HotelsAdminUpdateComponent implements OnInit {

  hotel:Hotel = new Hotel();
  newRoom:HotelRoom = new HotelRoom();
  hotelId:number;

  constructor(private http:HttpClient, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.loadHotel();
  }

  public loadHotel(){
    this.route.params.subscribe(params=>{
      this.hotelId = +params["id"];

      this.http.get<Hotel>('http://localhost:8080/api/hotel/'+this.hotelId).subscribe((data) => {
        this.hotel = data;
        //this.availableRoomsList = this.hotel.hotelRooms;
        console.log(this.hotel);
      });

    })
  }

  public updateHotel(){
    this.http.put<Hotel>('http://localhost:8080/api/hotel', this.hotel).subscribe((data) => {

      this.router.navigate(["/hotels-admin"]);
    });
  }

  public addRoom(){
    this.newRoom.hotelId = this.hotelId;
    this.http.post<HotelRoom>('http://localhost:8080/api/hotel-room', this.newRoom).subscribe((data) => {
      this.loadHotel();
      this.newRoom = new HotelRoom();
    });
  }

  public removeRoom(id:number){
    console.log("removeRoom id: "+id);
    console.log("removeRoom hotelId: "+this.hotelId);
    this.http.delete<MessageResponse>('http://localhost:8080/api/hotel-room/'+id).subscribe((data) => {
      this.loadHotel();
      alert(data.message);
      //this.newHotel = new Hotel();
    });
  }


}
