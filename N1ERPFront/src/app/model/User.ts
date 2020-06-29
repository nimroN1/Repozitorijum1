import {Address} from '../model/Address';
import { Reservation } from './Reservation';

export class User{
    id:number;
	username:String;
	password:String;
	firstName:String;
	lastName:String;
	role:String;
	address:Address;
	reservations:Reservation[] = [];
}