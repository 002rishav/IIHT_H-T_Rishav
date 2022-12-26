import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BookService } from 'src/app/Services/book.service';
import { UserAuthService } from 'src/app/Services/user-auth.service';
import { UserStoreService } from 'src/app/Services/user-store.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public userName: string = "";

  constructor(
    private bookService: BookService,
    private store: UserStoreService,
    private auth: UserAuthService
    ) { }
  
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

  addBooktodb(registerForm: FormGroup) {
    console.log(this.registerForm.valid);
    this.bookService.addBook(registerForm.value,this.userName).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.reset();
        alert("Book Added");
      },
      (err) => {
        console.log(err);
      }
    );
  }
  ngOnInit(): void {
    this.store.getuserNameFromStore().subscribe(
      val => {
        let userNameFromToken = this.auth.getUserNameFromToken();
        this.userName = val || userNameFromToken
      }
    );
  }
}
