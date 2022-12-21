import { Component, OnInit } from '@angular/core';
import User from 'src/app/Entity/user';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {

  title:String = 'Please fill the form below';

  user: User = new User();

  save(){
    const observables = this.userService.saveUser(this.user);
    observables.subscribe(
      (response:any) => {
        console.log(response);
      }, function(error){
        console.log(error);
        alert("something went wrong, Please try again!")
      })}
      //earlier save method
    // console.log("Hello " + this.user.firstName + ' ' + this.user.lastName);
    // console.log('your email id is ' + this.user.email);
    // console.log('your age is ' + this.user.age + ' and gender is ' + this.user.gender);

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

}
