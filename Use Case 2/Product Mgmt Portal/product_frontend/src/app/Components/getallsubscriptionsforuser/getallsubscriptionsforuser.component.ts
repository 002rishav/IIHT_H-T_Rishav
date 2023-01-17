import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/Services/book.service';
import { UserAuthService } from 'src/app/Services/user-auth.service';
import { UserStoreService } from 'src/app/Services/user-store.service';

@Component({
  selector: 'app-getallsubscriptionsforuser',
  templateUrl: './getallsubscriptionsforuser.component.html',
  styleUrls: ['./getallsubscriptionsforuser.component.css']
})
export class GetallsubscriptionsforuserComponent implements OnInit {

  private userName: String ="";
  
  constructor(
    private bookService: BookService,
    private store: UserStoreService,
    private auth: UserAuthService
  ){}
  
  subscriptionDetails: any;
  bookcontent: any;

  ngOnInit(): void {
    this.store.getuserNameFromStore().subscribe(
      val => {
        let userNameFromToken = this.auth.getUserNameFromToken();
        this.userName = val || userNameFromToken
      }
    );
    this.bookService.getallsubscriptions(this.userName).subscribe(
      (resp) => {
        console.log(resp);
        this.subscriptionDetails = resp;
      },
      (err) =>{
        alert("Unable to fetch subscriptions.");
      });
  }

  readbook(bookid:String,username:String){
    this.bookService.read(bookid,username).subscribe(
      (resp) => {
        console.log(resp);
        this.bookcontent = resp; 
      },
      (err) =>{
        alert("Unable to fetch book details.");
      });
  }

}
