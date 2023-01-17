import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BookService } from 'src/app/Services/book.service';
import { UserAuthService } from 'src/app/Services/user-auth.service';
import { UserStoreService } from 'src/app/Services/user-store.service';

@Component({
  selector: 'app-search-subscription',
  templateUrl: './search-subscription.component.html',
  styleUrls: ['./search-subscription.component.css']
})
export class SearchSubscriptionComponent implements OnInit {
  
  private userName: String ="";

  constructor(
    private bookService: BookService,
    private store: UserStoreService,
    private auth: UserAuthService
  ){}
  
  ngOnInit(): void {
    this.store.getuserNameFromStore().subscribe(
      val => {
        let userNameFromToken = this.auth.getUserNameFromToken();
        this.userName = val || userNameFromToken
      }
    );
  }

  subscriptionDetails: any;

  searchForm = new FormGroup({
    bookId: new FormControl("", [Validators.required])
  });

  get BookId(): FormControl{
    return this.searchForm.get("bookId") as FormControl;
  }

  search(searchForm:any){
    this.bookService.getsubscription(searchForm.get("bookId").value , this.userName).subscribe(
      (resp) => {
        this.subscriptionDetails = resp;
      },
      (err) => {
        alert("Subscription not found");
      }
    );
  }

}
