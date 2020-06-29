import { Reservation } from './Reservation';

export class HotelRoom{
    id:number;
	roomNumber:String;
	numberOfBeds:number;
	hotelId:number;
	roomReservations:Reservation[] = [];
}