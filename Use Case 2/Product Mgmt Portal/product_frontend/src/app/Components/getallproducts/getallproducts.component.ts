import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BookService } from 'src/app/Services/book.service';
import { UserAuthService } from 'src/app/Services/user-auth.service';

@Component({
  selector: 'app-getallproducts',
  templateUrl: './getallproducts.component.html',
  styleUrls: ['./getallproducts.component.css']
})
export class GetallproductsComponent implements OnInit {

  constructor(private bookService: BookService) { }
  
  productDetails: any;
  
  ngOnInit() {
    this.bookService.getallproducts().subscribe(
      (resp) => {
        console.log(resp);
        this.productDetails = resp;
      },
      (err) => {
        console.log(err);
        alert("Unable to Fetch Products");
      }
    );
  }

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

  productToUpdate = {
    id:"",
    name:"",
    description:"",
    price:""
  }
  
  edit(product: any){
    this.productToUpdate = product;
  }

  updateProduct(){
    this.bookService.updateproduct(this.productToUpdate,this.productToUpdate.id).subscribe(
      (resp) => {
        console.log(resp);
        alert("Product Updated Successfully"); 
      },
      (err) => {
        console.log(err);
        alert("Error occurred in updating");
      }
    );
  }

  deleteProduct(product: any){
    this.bookService.delete(product.id).subscribe(
      (resp) => {
        console.log(resp);
        alert("Product Deleted Successfully");
        this.ngOnInit(); 
      },
      (err) => {
        console.log(err);
        alert("Error occurred in deleting");
      }
    );
  }


}
