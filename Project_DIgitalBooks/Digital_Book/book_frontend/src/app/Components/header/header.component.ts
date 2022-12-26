import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookService } from 'src/app/Services/book.service';
import { UserAuthService } from 'src/app/Services/user-auth.service';
import { UserStoreService } from 'src/app/Services/user-store.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public userName: string = "";

  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
    public userService: UserService,
    public bookService: BookService,
    private store: UserStoreService
  ) {}

  ngOnInit(): void {
    this.store.getuserNameFromStore().subscribe(
      val => {
        let userNameFromToken = this.userAuthService.getUserNameFromToken();
        this.userName = val || userNameFromToken
      }
    );
  }

  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['']);
  }
}
