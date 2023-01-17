import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BookService } from 'src/app/Services/book.service';
import { UserAuthService } from 'src/app/Services/user-auth.service';

@Component({
  selector: 'app-getallbooks',
  templateUrl: './getallbooks.component.html',
  styleUrls: ['./getallbooks.component.css']
})
export class GetallbooksComponent implements OnInit {

  constructor(private bookService: BookService) { }
  
  bookDetails: any;
  
  ngOnInit() {
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

  registerForm = new FormGroup({
    logo: new FormControl("", [Validators.required]),
    title: new FormControl("", [Validators.required, Validators.pattern("^[a-zA-Z ]*$")]),
    author: new FormControl("",[Validators.required, Validators.pattern("^[a-zA-Z ]*$")]),
    price: new FormControl("", [Validators.required, Validators.pattern("^[0-9]+(\.[0-9]+)?$")]),
    category: new FormControl("", [Validators.required, Validators.pattern("^[a-zA-Z ]*$")]),
    content: new FormControl("",[Validators.required]),
    publisher: new FormControl("",[Validators.required]),
    publishedDate: new FormControl("",[Validators.required]),
    active: new FormControl("",[Validators.required])
  });

  get BookName(): FormControl{
    return this.registerForm.get("title") as FormControl;
  }
  get BookAuthor(): FormControl{
    return this.registerForm.get("author") as FormControl;
  }
  get BookPrice(): FormControl{
    return this.registerForm.get("price") as FormControl;
  }
  get BookGenre(): FormControl{
    return this.registerForm.get("category") as FormControl;
  }
  get Active(): FormControl{
    return this.registerForm.get("active") as FormControl;
  }
  get Logo(): FormControl{
    return this.registerForm.get("logo") as FormControl;
  }
  get Content(): FormControl{
    return this.registerForm.get("content") as FormControl;
  }
  get Publisher(): FormControl{
    return this.registerForm.get("publisher") as FormControl;
  }
  get PublishedDate(): FormControl{
    return this.registerForm.get("publishedDate") as FormControl;
  }

  bookToUpdate = {
    id:"",
    bookId:"",
    authorId:"",
    author:"",
    logo:"",
    title:"",
    category:"",
    price:"",
    publisher:"",
    publishedDate:"",
    content:"",
    active:""
  }
  
  edit(book: any){
    this.bookToUpdate = book;
  }

  updateBook(){
    this.bookService.updatebook(this.bookToUpdate,this.bookToUpdate.bookId,this.bookToUpdate.authorId).subscribe(
      (resp) => {
        console.log(resp);
        alert("Book Updated Successfully"); 
      },
      (err) => {
        console.log(err);
        alert("Error occurred in updating");
      }
    );
  }

  updateStatus(){
    this.bookService.updatestatus(this.bookToUpdate,this.bookToUpdate.bookId,this.bookToUpdate.authorId).subscribe(
      (resp) => {
        console.log(resp);
        alert("Status Updated Successfully");
      },
      (err) => {
        console.log(err);
        alert("Error occurred in updating");
      }
    );
  }

}
