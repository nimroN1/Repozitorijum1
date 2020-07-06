import { Address } from './Address';
import { HotelRoom } from './HotelRoom';

export class Hotel{
    id:number;
	name:String;
	address:Address = new Address();
	hotelRooms:HotelRoom[] = [];
}