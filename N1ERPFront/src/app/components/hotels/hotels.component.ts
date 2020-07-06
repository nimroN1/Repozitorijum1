import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { HttpClient } from '@angular/common/http';
import { Address } from 'src/app/model/Address';


@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {

  public hotels: Hotel[] = [];
  public hotelsFiltered: Hotel[] = [];
  public addresses: Address[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<Hotel[]>('http://localhost:8080/api/hotel/all').subscribe((data) => {
      this.hotels = data;
      this.hotelsFiltered = data;
      console.log(this.hotels);
    });

    this.http.get<Address[]>('http://localhost:8080/api/address/unique').subscribe((data) => {
      this.addresses = data;
      console.log(this.addresses);
    });
  }

  public filterHotels(address: Address) {
    if (address == null)
      this.hotelsFiltered = this.hotels;
    else {
      this.hotelsFiltered = [];
      for (let i = 0; i < this.hotels.length; i++) {
        if (this.hotels[i].address.city === address.city
          && this.hotels[i].address.country === address.country) {
          this.hotelsFiltered.push(this.hotels[i]);
        }
      }
    }
  }
}
