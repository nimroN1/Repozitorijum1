import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomWriteServiceService {

  constructor() { }

  public simpleLog(message:String){
    console.log(message);
  }

  public logUppercaseString(message:String){
    console.log(message.toUpperCase());
  }
}
