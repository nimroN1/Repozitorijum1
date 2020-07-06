import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelRoom } from 'src/app/model/HotelRoom';
import { DateRangeDTO } from 'src/app/model/DateRangeDTO';
import { Reservation } from 'src/app/model/Reservation';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {

  hotel:Hotel = new Hotel();

  reservationDateFrom:Date;
  reservationDateTo:Date;

  availableRoomsList:HotelRoom[] = [];

  constructor(private http:HttpClient, private route:ActivatedRoute, private router:Router) { 

  }

  ngOnInit(): void {
    this.loadHotel();
  }

  public findAvailableRooms(){
    let dateRangeDTO = new DateRangeDTO();
    dateRangeDTO.dateFrom = this.reservationDateFrom;
    dateRangeDTO.dateTo = this.reservationDateTo;

    this.http.post<HotelRoom[]>('http://localhost:8080/api/hotel-room/'+this.hotel.id+'/available', dateRangeDTO).subscribe((data) => {
    this.availableRoomsList = data;
    console.log(this.availableRoomsList);
    });
  }


  public makeReservation(id:number){
    let reservation = new Reservation();
    reservation.reservationDateFrom = this.reservationDateFrom;
    reservation.reservationDateTo = this.reservationDateTo;
    reservation.hotelRoomId = id;
    reservation.userId = 1;
    this.http.post<Reservation>('http://localhost:8080/api/reservation', reservation).subscribe((data) => {
  
    alert("Reservation successfully made.");

    this.loadHotel();

    });
  }


  public loadHotel(){
    this.availableRoomsList = [];
    this.route.params.subscribe(params=>{
      var id = +params["id"];
      console.log("id: "+id);

      this.http.get<Hotel>('http://localhost:8080/api/hotel/'+id).subscribe((data) => {
        this.hotel = data;
        //this.availableRoomsList = this.hotel.hotelRooms;
        console.log(this.hotel);
      });

    })
  }

}
