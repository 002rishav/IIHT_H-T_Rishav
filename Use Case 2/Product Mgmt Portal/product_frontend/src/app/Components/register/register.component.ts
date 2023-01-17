import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from 'src/app/Services/user-auth.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
  constructor(
    private userService: UserService,
    private userAuthService: UserAuthService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  registerForm = new FormGroup({
    userName: new FormControl("", [Validators.required]),
    userFirstName: new FormControl("", [Validators.required]),
    userLastName: new FormControl("", [Validators.required]),
    userPassword: new FormControl("", [Validators.required])
  });

  get username(): FormControl{
    return this.registerForm.get("userName") as FormControl;
  }
  get firstname(): FormControl{
    return this.registerForm.get("userFirstName") as FormControl;
  }
  get lastname(): FormControl{
    return this.registerForm.get("userLastName") as FormControl;
  }
  get password(): FormControl{
    return this.registerForm.get("userPassword") as FormControl;
  }

  registerUser(registerForm: any){
    
  }

  registerAdmin(registerForm: any){
    this.userService.registeradmin(registerForm.value).subscribe(
      (response:any) => {
        console.log(response);
        registerForm.reset();
        alert("Admin user created.Login with your credentials");
        this.router.navigate(['/login']);
      },
      (err) => {
        console.log(err);
      }
    );
  }

  loginf(){
    this.router.navigate(['/login']);
  }

  registerfu(){
    this.router.navigate(['/register_user']);
  }
  registerfa(){
    this.router.navigate(['/register']);
  }

}
