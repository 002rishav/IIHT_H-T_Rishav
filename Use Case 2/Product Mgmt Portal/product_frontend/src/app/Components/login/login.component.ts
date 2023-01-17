import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from 'src/app/Services/user-auth.service';
import { UserStoreService } from 'src/app/Services/user-store.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit  {
  constructor(
    private userService: UserService,
    private userAuthService: UserAuthService,
    private router: Router,
    private store: UserStoreService
  ) {}

  ngOnInit(): void {}

  loginForm = new FormGroup({
    userName: new FormControl("", [Validators.required]),
    userPassword: new FormControl("", [Validators.required])
  });

  get username(): FormControl{
    return this.loginForm.get("userName") as FormControl;
  }
  get password(): FormControl{
    return this.loginForm.get("userPassword") as FormControl;
  }

  login(loginForm: any) {
    this.userService.login(loginForm.value).subscribe(
      (response: any) => {
        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken);
        const tokenPayload = this.userAuthService.decodedToken();
        this.store.setuserNameForStore(tokenPayload.sub);
        const role = response.user.role[0].roleName;
        if (role === 'Admin') {
          this.router.navigate(['/admin']);
        } else {
          this.router.navigate(['/user']);
        }
      },
      (error) => {
        console.log(error);
        alert("Check username and password.");
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
