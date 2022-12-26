import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/Services/book.service';
import { UserAuthService } from 'src/app/Services/user-auth.service';
import { UserStoreService } from 'src/app/Services/user-store.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  public userName: string = "";

  constructor(
    private bookService: BookService,
    private auth: UserAuthService,
    private store: UserStoreService
    ) { }

  bookDetails: any;

  ngOnInit() {
    this.store.getuserNameFromStore().subscribe(
      val => {
        let userNameFromToken = this.auth.getUserNameFromToken();
        this.userName = val || userNameFromToken
      }
    );
    this.bookService.getallbooks().subscribe(
      (resp) => {
        console.log(resp);
        this.bookDetails = resp;
      },
      (err) => {
        console.log(err);
        alert("Unable to Fetch Books");
      }
    );
  }

  subscribeBook(book: any) {
    this.bookService.subscribebook(book, book.bookId).subscribe(
      (resp) => {
        console.log(resp);
        if (Object.values(resp).at(0) == 403) {
          alert("Cannot Subscribe as the book is blocked.");
        }
        else if (Object.values(resp).at(0) == 500) {
          alert("Already Subscribed");
        }
        else {
          alert("Book Subscribed");
        }
      },
      (err) => {
        console.log(err);
      }
    );
  }

  unsubscribe(book:any){
    this.bookService.unsubscribebook(book, book.bookId, this.userName).subscribe(
      (resp) => {
        console.log(resp);
        if (Object.values(resp).at(0) == 403) {
          alert("Subscription not found.");
        }
        else if (Object.values(resp).at(0) == 500) {
          alert("Unable to unsubscribe");
        }
        else if (Object.values(resp).at(0) == 400) {
          alert("Cannot unsubscribe as it is more than 24 hours");
        }
        else{
          alert("Book Un-Subscribed");
        }
      },
      (err) => {
        console.log(err);
      }
    );
  }

}
