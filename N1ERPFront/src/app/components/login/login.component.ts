import { Component, OnInit } from '@angular/core';
import { UserCredentialsDTO } from 'src/app/model/UserCredentialsDTO';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/app/model/LoginDTO';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:String;
  password:String;

  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
  }

  login(){
    let user = new UserCredentialsDTO();

    user.username = this.username;
    user.password = this.password;

    this.httpClient.post<LoginDTO>("http://localhost:8080/api/user/login", user).subscribe((data) => {
      localStorage.setItem("token", data.token);
      localStorage.setItem("user", data.role);
    });
  }

}
