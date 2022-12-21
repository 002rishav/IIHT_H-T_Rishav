import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL = "http://localhost:5000/users";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  saveUser( user:{
    firstName:String;
    lastName:String ;
    age: number;
    gender:String;
    email:String;
  }){
    return this.http.post(BASE_URL,user);
  }

  getUsers() {
    return this.http.get(BASE_URL);
  }

  deleteUsers(user){
    return this.http.delete(BASE_URL + "/" +user.id);
  }

  constructor(private http: HttpClient) {}
}
