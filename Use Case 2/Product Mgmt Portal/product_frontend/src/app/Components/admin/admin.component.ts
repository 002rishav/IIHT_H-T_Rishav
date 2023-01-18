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
      name: new FormControl("", [Validators.required, Validators.pattern("^[a-zA-Z ]*$")]),
      description: new FormControl("",[Validators.required, Validators.pattern("^[a-zA-Z ]*$")]),
      price: new FormControl("", [Validators.required, Validators.pattern("^[0-9]+(\.[0-9]+)?$")]),
    });
  
    get ProductName(): FormControl{
      return this.registerForm.get("name") as FormControl;
    }
    get ProductDescription(): FormControl{
      return this.registerForm.get("description") as FormControl;
    }
    get ProductPrice(): FormControl{
      return this.registerForm.get("price") as FormControl;
    }

  addProducttodb(registerForm: FormGroup) {
    console.log(this.registerForm.valid);
    this.bookService.addProduct(registerForm.value).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.reset();
        alert("Product Added");
      },
      (err) => {
        console.log(err);
        alert("Error occurred in adding product");
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
